package civilization_unites;
import civilization_joueurs.Joueur;

public abstract class UniteCivileTerrestre extends UniteCivile
{
    boolean peutMarcher = true;
    
    public UniteCivileTerrestre(Joueur joueur, int or, int bois, int fer, int nourriture, int tpsConstruction, int defense)
    {
        super(joueur, or, bois, fer, nourriture, tpsConstruction, defense);
    }
}

