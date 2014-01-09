package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    public UniteMilitaire(Joueur joueur, int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, int attDist, int attPts, int attZones)
    {
        super(joueur, or, bois, fer, nourriture, tpsConstruction, defense);
    }
    
    @Override public String toString()
    {
        return this.getClass().getSimpleName() + " (" + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();

    }
}
