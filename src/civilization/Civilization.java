package civilization;


import civilization_joueurs.Joueur;
import civilization_unites.*;
import civilization_batiments.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Civilization 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        //Aeroport monAeroport = new Aeroport();
        Aeroport monAeroport = new Aeroport();
        
        
        // Pour executer les constructeurs
        for (Constructor c : monAeroport.getConstructions().values()) {
            try {
                System.out.println(c.newInstance(j1, null, null));
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Civilization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // Pour lister + executer les actions
        for (Method m : monAeroport.getActions().values()) {
            try {
                System.out.println(m.getName());
                m.invoke(monAeroport);
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Civilization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}