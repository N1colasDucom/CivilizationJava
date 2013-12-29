package civilization_batiments;

import civilization_joueurs.Joueur;

public abstract class Batiment 
{    
    public int pointsDeVie;
    public int tempsConstruction;
    Joueur Proprietaire;
    
    public void Batiment(Joueur j){
       Proprietaire=j;
       Proprietaire.ajouterBatiment(this);
    }
}