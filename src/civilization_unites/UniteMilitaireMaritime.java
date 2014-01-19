package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteMilitaireMaritime extends UniteMilitaire
{
    public UniteMilitaireMaritime(
            Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie
            ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, attDist, attPts, attZones, dist, caseParent, batimentParent, ptVie);
    }
    
    @Override 
    public boolean peutAttaquer(Unite unite)
    {
        switch (unite.getClass().getSuperclass().getSimpleName()) {
            case "UniteCivileAerien" : return false;
            case "UniteCivileMaritime" : return true;
            case "UniteCivileTerrestre" : return true;
            case "UniteMilitaireAerien" : return false;
            case "UniteMilitaireMaritime" : return true;
            case "UniteMilitaireTerrestre" : return true;
            default: return false;
        }
    }
    
    @Override
    public List<String> movableTypes() 
    {
        List<String> types=new ArrayList<>();
        types.add("Eau");
        return types;
    }
}
