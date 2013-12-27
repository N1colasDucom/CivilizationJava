/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine.mapgenerator;

/**
 *
 * @author Nicolas
 */
public class Noise {


    
    public static float[][] Perl(){
            Perlin noise = new Perlin();
        float[][] seed =  noise.GenerateWhiteNoise(100, 100);
        System.out.println("WHIIIIITE~~~~~~~~~~~~~~~~~~~~~~~");
    for (int i = 0;i < seed.length; i++){
        for ( int j = 0; j < seed[i].length; j++){
           // System.out.println("("+i+":"+j+")"+seed[i][j] + " ");
        }
    }
     float[][] seedE = noise.GenerateSmoothNoise( seed,2);
        System.out.println("SMOOOOOTH~~~~~~~~~~~~~~~~~~~~~~~~~");
     for (int i = 0;i < seedE.length; i++){
            for ( int j = 0; j < seedE[i].length; j++){
               // System.out.println("("+i+":"+j+")"+seedE[i][j] + " ");
            }
     }
     
     float[][] perlinNoise = noise.GeneratePerlinNoise(seedE,6);
        System.out.println("PERLIIIIN~~~~~~~~~~~~~~~~~~~~~~~");
     for (int i = 0;i < perlinNoise.length; i++){
            for ( int j = 0; j < perlinNoise[i].length; j++){
               // System.out.println("("+i+":"+j+")"+perlinNoise[i][j] + " ");
            }
        }
     return perlinNoise;
    }
    
    
    
    
    public static void GenerateMap() {
                        //generates 100 by 100 data points within the specified range

       float[][] perlinNoise1=Perl();
       float[][] perlinNoise2=Perl();
    
        
    double[][] result=new double[100][100];
    double[][] result2=new double[100][100];

    for(int i=0;i<100;i++){
        for(int j=0;j<100;j++){
            result[i][j]=perlinNoise1[i][j];
        }
    }
        for(int i=0;i<100;i++){
        for(int j=0;j<100;j++){
            result2[i][j]=perlinNoise2[i][j];
        }
    }
        
    ImageWriter.greyWriteImage(result,result2);
    result=null;
    result2=null;
    perlinNoise1=null;
    perlinNoise2=null;

    }
    
}
