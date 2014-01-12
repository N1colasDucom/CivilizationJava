package civilization_batiments;

import civilization_joueurs.Joueur;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class Batiment 
{    
    public Joueur joueur;
    public int pointsDeVie;
    public int tempsConstruction;
        
    public void Batiment(Joueur j)
    {
       this.joueur = j;
       this.joueur.ajouterBatiment(this);
    }
    
    public abstract Map<String, Constructor> getConstructions();
    public abstract Map<String, Method> getActions();
    
    public boolean reparer()
    {
        System.out.println("REPARATION DE : \n" + this.toString());
        return true;
    }
    public boolean detruire()
    {
        System.out.println("DESTRUCTION DE : \n" + this.toString());
        return true;
    }
}

