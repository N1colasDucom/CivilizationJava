package civilization_batiments;

import civilization_joueurs.Joueur;
import civilization_unites.Unite;
import java.util.ArrayList;

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
}