package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteCivileMaritime extends UniteCivile
{
    boolean peutNaviguer = true;
    
    public UniteCivileMaritime(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense,
            int coordX, int coordY,
            int dist)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, coordX, coordY, dist);
    }
}