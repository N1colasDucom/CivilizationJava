package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    public UniteMilitaire(Joueur joueur)
    {
        super(joueur);
    }
    
    @Override public String toString()
    {
        return this.getClass().getSimpleName() + " (" + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
