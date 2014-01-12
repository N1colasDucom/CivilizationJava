package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

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
     */
    public UniteMilitaireAerien(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, attDist, attPts, attZones, dist, caseParent, batimentParent);
    }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        String typeUnite = this.getClass().getSuperclass().getSimpleName();
        switch (typeUnite) {
            case "UniteMilitaireAerien":
            case "UniteMilitaireMaritime":
            case "UniteMilitaireTerrestre":
            case "UniteCivileAerien":
            case "UniteCivileTerrestre":
            case "UniteCivileMaritime":
                return true;
            default:
                return false;
        }
    }

}
