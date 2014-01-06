package civilization;

import civilization_joueurs.Joueur;
import civilization_unites.*;
import civilization_batiments.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Civilization {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        Maison maMaison = new Maison();
        UCA_AviondeLigne monAvion = new UCA_AviondeLigne(j2, 2, 2);
        
        for (Class<? extends Unite> u : Aeroport.unitesDisponiblesPourConstruction) {
            //System.out.println(u.getSimpleName() +" :");
            for (Field f : u.getDeclaredFields()) {
                //System.out.println(f.getName());
            }
                        
            System.out.println(u.getField("nom").get(u));
        }
    }
}