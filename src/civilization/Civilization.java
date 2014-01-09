package civilization;


import civilization_joueurs.Joueur;
import civilization_unites.*;
import civilization_batiments.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Civilization {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {

        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        UCA_AviondeLigne monAvion = new UCA_AviondeLigne(j2);
        Aeroport monAeroport = new Aeroport();
        
        for (Class unite : monAeroport.getUnitesDisponiblesPourConstruction()) {
            System.out.println(unite.getField("nom").get(unite));
        }
        
        //monAvion.test();
        
        /*for (Class u : Aeroport.unitesDisponiblesPourConstruction) {
            System.out.println(u.getField("nom").get(u));
            
            for (Method mth : u.getDeclaredMethods()) {
                System.out.println("   "+mth.getName());
            }
        }*/

    }

}