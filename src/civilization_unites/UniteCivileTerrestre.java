package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteCivileTerrestre extends UniteCivile
{
    boolean peutMarcher = true;
    
    public UniteCivileTerrestre(
            Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie
    ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie, 0, 0, 0, 0);
    }
    
    @Override
    public List<String> movableTypes()
    {
       List<String> types=new ArrayList<>();;
       types.add("Sable");
       types.add("Terre");
       types.add("Foret");
                   
       return types;
    }
}

