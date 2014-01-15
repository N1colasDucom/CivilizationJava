package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.List;

public abstract class UniteCivileMaritime extends UniteCivile
{
    boolean peutNaviguer = true;
    public UniteCivileMaritime(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense,
            int dist,
            Case caseParent, Batiment batimentParent)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent);
    }
}

