package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteCivileMaritime extends UniteCivile
{
    boolean peutNaviguer = true;
    
    public UniteCivileMaritime(Joueur joueur, int or, int bois, int fer, int nourriture, int tpsConstruction, int defense)
    {
        super(joueur, or, bois, fer, nourriture, tpsConstruction, defense);
    }
}