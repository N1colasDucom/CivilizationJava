package civilization.game_engine.mapgenerator;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

public class ImageWriter {
    //just convinence methods for debug

    public static void greyWriteImage(double[][] data,double[][] data2){
        //this takes and array of doubles between 0 and 1 and generates a grey scale image from them
        String str1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<map version=\"1.0\" orientation=\"orthogonal\" width=\"100\" height=\"100\" tilewidth=\"32\" tileheight=\"32\">\n"
                + " <tileset firstgid=\"1\" name=\"map\" tilewidth=\"32\" tileheight=\"32\">\n"
                + "  <image source=\"map.png\" width=\"96\" height=\"96\"/>\n"
                + " </tileset>\n"
                + " <layer name=\"Tile Layer 1\" width=\"100\" height=\"100\">\n"
                + "  <data encoding=\"base64\" compression=\"gzip\">\n";
        String str = "";
        String str2 = "\n</data>\n"
                + " </layer>\n"
                + "</map>";
        BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int y = 0; y < data[0].length; y++)
        {
          for (int x = 0; x < data.length; x++)
          {

            //  System.out.println(data[x][y]);
              Color col=null;        
             if (data[x][y]<0.20){col=new Color(0,0,153); sb.append("1000");;}
             else if((data[x][y]>=0.20 && data[x][y]<0.40)){col=Color.blue;sb.append("2000");;}
             else if ((data[x][y]>=0.40 && data[x][y]<0.45)){col=new Color(255,255,204);sb.append("3000");;}
             else if ((data[x][y]>=0.45 && data[x][y]<0.75)){
             if (data2[x][y]<0.6) {
                    col=Color.green;sb.append("4000");
                }
                 else{
                    col=new Color(0,102,0);sb.append("5000");
                }
             }
             else if ((data[x][y]>=0.45 && data[x][y]<0.75)&& data2[x][y]>=0.6){col=new Color(0,102,0);sb.append("5000");}
             else if ((data[x][y]>=0.75 && data[x][y]<0.91)){col=Color.gray;sb.append("6000");}
            else if (data[x][y]>=0.91 && data[x][y]<=1){col=Color.white;sb.append("7000");}
              
              
              
            image.setRGB(x, y, col.getRGB());
            
          }
         
        }
        
       sb2.append(compress(sb,"UTF-8"));
       sb.setLength(0);
       sb.append(str1);
       sb.append(sb2.toString());
       sb.append(str2);
      
       
       image.flush();
        
        try {
            // retrieve image
            File outputfile = new File("Graphics/Tileset/"+randomName()+".png");
            System.out.println("SAved!");
            outputfile.createNewFile();

            ImageIO.write(image, "png", outputfile);
           
        } catch (IOException e) {
            //o no!
        }
       try {
          PrintWriter out = new PrintWriter("Graphics/Tileset/map.tmx");
           System.out.println("SAved!");
          out.println(sb.toString());
          
           out.close();
            str=null;
        } catch (IOException e) {
            //o no!
        }
    }


    /*public static void main(String args[]){
        double[][] data=new double[2][4];
        data[0][0]=0.5;
        data[0][5]=1;
        data[1][0]=0.7;
        data[1][6]=1;

        greyWriteImage(data);
    }*/
    
    public static String randomName(){
        Random ran = new Random();
        int top = 3;
        char data = ' ';
        String dat = "";

        for (int i=0; i<=top; i++) {
          data = (char)(ran.nextInt(25)+97);
          dat = data + dat;
            }
    return new String(dat);
    }
    
    private static String compress(StringBuilder sb, String charset) {
      byte byteAry[] = null;
    
        try {
            byteAry = sb.toString().getBytes(charset);
            
        } catch (UnsupportedEncodingException ex) {
            printStackTrace();
        }
      sb.setLength(0);
      for(int i = 0; i < byteAry.length; i++) {
          if(byteAry[i]>=48 ){
          sb.append(byteAry[i]-48);
            byteAry[i] = (byte) (byteAry[i]-48);
          }
      } 

      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      try {
         OutputStream deflater = new GZIPOutputStream(buffer);
        
           deflater.write(byteAry);
           deflater.close();
         byteAry=null;
      } 
      catch (IOException e) {
         throw new IllegalStateException(e);
      }
      return new BASE64Encoder().encode(buffer.toByteArray());
   }
     
}