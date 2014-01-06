package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    public UniteMilitaire(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, 
            int defense, int attDist, int attPts, int attZones,
            int coordX, int coordY,
            int dist)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, coordX, coordY, dist);
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
