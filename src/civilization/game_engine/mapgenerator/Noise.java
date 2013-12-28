/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine.mapgenerator;

import civilization.Plateau;

/**
 *
 * @author Nicolas
 */
public class Noise {


    
    public static float[][] Perl(){
            Perlin noise = new Perlin();
        float[][] seed =  Perlin.GenerateWhiteNoise(100, 100);
        System.out.println("WHIIIIITE~~~~~~~~~~~~~~~~~~~~~~~");
    
     float[][] seedE = noise.GenerateSmoothNoise( seed,2);
        System.out.println("SMOOOOOTH~~~~~~~~~~~~~~~~~~~~~~~~~");

     
     float[][] perlinNoise = noise.GeneratePerlinNoise(seedE,6);
        System.out.println("PERLIIIIN~~~~~~~~~~~~~~~~~~~~~~~");
     return perlinNoise;
    }
    
    
    
    
    public static Plateau GenerateMap() {
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
       
       perlinNoise1=null;
       perlinNoise2=null;
    return ImageWriter.WriteImage(result,result2);

    }
    
}
