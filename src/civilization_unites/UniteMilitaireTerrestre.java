package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UniteMilitaireTerrestre extends UniteMilitaire
{
    public UniteMilitaireTerrestre(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, attDist, attPts, attZones, dist, caseParent, batimentParent, ptVie);
    }
    
    @Override
    public List<String> movableTypes(){
       List<String> types=new ArrayList<>();
       types.add("Sable");
       types.add("Terre");
       types.add("Foret");
       return types;
     }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        if (super.peutAttaquer(unite)) {
            String typeUnite = this.getClass().getSuperclass().getSimpleName();
            switch (typeUnite) {
                case "UniteMilitaireTerreste":
                case "UniteCivileTerreste":
                    return true;
                default:
                    return false;
            }
        }
        
        return false;
    }
}

