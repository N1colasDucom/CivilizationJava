package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteMilitaireAerien extends UniteMilitaire
{
    /**
     * Crée une Unité Militaire Aérien.
     * @param joueur (required) joueur associé
     * @param nom (required) nom de l'unité
     * @param or (required) or nécessaire
     * @param bois (required) bois nécessaire
     * @param fer (required) fer nécessaire
     * @param nourriture (required) nourriture nécessaire
     * @param tpsConstruction (required) temps de construction nécessaire
     * @param defense (required) points de défense
     * @param attDist (required) distance d'attaque
     * @param attPts (required) points d'attaque
     * @param attZones (required) zones d'attaque
     * @param dist
     * @param caseParent
     * @param batimentParent
     * @param ptVie
     */
    public UniteMilitaireAerien(
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
        if(!this.joueur.equals(unite.joueur)){
            switch (unite.getClass().getSuperclass().getSimpleName()) {
                case "UniteCivileAerien" : 
                case "UniteCivileMaritime" : 
                case "UniteCivileTerrestre" : 
                case "UniteMilitaireAerien" : 
                case "UniteMilitaireMaritime" : 
                case "UniteMilitaireTerrestre" : return true;
                default: return false;
            }
        }
        return false;
    }
    
    @Override
    public List<String> movableTypes()
    {
        List<String> types=new ArrayList<>(); 
        types.add("Eau");
        types.add("Sable");
        types.add("Terre");
        types.add("Foret");
        types.add("Montagne");
        return types;
    }
}
