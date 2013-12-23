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
                + "  <data encoding=\"base64\" compression=\"gzip\">";
        String str = "";
        String str2 = "</data>\n"
                + " </layer>\n"
                + "</map>";
        BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data[0].length; y++)
        {
          for (int x = 0; x < data.length; x++)
          {
           /* if (data[x][y]>1){
                data[x][y]=1;
            }
            if (data[x][y]<0){
                data[x][y]=0;
            }*/
            //  System.out.println(data[x][y]);
              Color col=null;         
             if (data[x][y]<0.20){col=new Color(0,0,153); str+="1000";}
             if ((data[x][y]>=0.20 && data[x][y]<0.40)){col=Color.blue;str+="2000";}
             if ((data[x][y]>=0.40 && data[x][y]<0.45)){col=new Color(255,255,204);str+="3000";}
             if ((data[x][y]>=0.45 && data[x][y]<0.75)&& data2[x][y]<0.6){col=Color.green;str+="4000";}
             if ((data[x][y]>=0.45 && data[x][y]<0.75)&& data2[x][y]>=0.6){col=new Color(0,102,0);str+="5000";}
             if ((data[x][y]>=0.75 && data[x][y]<0.91)){col=Color.gray;str+="6000";}
             if (data[x][y]>=0.91 && data[x][y]<=1){col=Color.white;str+="7000";}
            image.setRGB(x, y, col.getRGB());
          }
          
        }
        str=compress(str,"UTF-8");
        str=str1+str+str2;
        System.out.println(str);
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
            out.println(str);
            out.close();
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
    
    private static String compress(String str, String charset) {
      byte byteAry[] = null;
        try {
            byteAry = str.getBytes(charset);
        } catch (UnsupportedEncodingException ex) {
            printStackTrace();
        }
      String test2="";
      for(int i = 0; i < byteAry.length; i++) {
          if(byteAry[i]>=48 ){
          test2= test2 + (byteAry[i]-48);
            byteAry[i] = (byte) (byteAry[i]-48);
          }
      }
      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      try {
         OutputStream deflater = new GZIPOutputStream(buffer);
        
           deflater.write(byteAry);
           deflater.close();
      } 
      catch (IOException e) {
         throw new IllegalStateException(e);
      }
      return new BASE64Encoder().encode(buffer.toByteArray());
   }
}