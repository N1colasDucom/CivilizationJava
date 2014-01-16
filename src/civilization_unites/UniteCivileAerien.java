package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteCivileAerien extends UniteCivile
{
    boolean peutVoler = true;
    boolean peutMarcher = true;
    

    public UniteCivileAerien(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense,
            int dist,
            Case caseParent, Batiment batimentParent)

    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent);
    }
    
    @Override
    public List<String> movableTypes(){
       List<String> types=new ArrayList<>();
       types.add("Eau");
       types.add("Sable");
       types.add("Terre");
       types.add("Foret");
       types.add("Montagne");
                   
       return types;
    }

}
