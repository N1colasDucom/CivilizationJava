package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    /**
     * Construit une Unité Militaire (hériant d'Unité).
     * @param joueur Propriétaire de l'unité
     * @param nom Nom de l'unité
     * @param or Quantité d'or requise
     * @param bois Quantité de bois requise
     * @param fer Quantité de fer requise
     * @param nourriture Quantité de nourriture requise
     * @param tpsConstruction Temps de construction requis
     * @param defense Points de défense
     * @param attDist Distance d'attaque
     * @param attPts Points d'attaque
     * @param attZones Zones d'attaque
     * @param dist Distance par tour
     * @param caseParent Case qui contient l'unité
     * @param batimentParent Bâtiment qui contient l'unité
     * @param ptVie Points de vie
     */
    public UniteMilitaire(
            Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, 
            int defense, int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie
    ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie, 0, 0, 0, 0);
    }
    
    public void attaquer(Case c) 
    {
        if (c.occupant!=null) {
            if (c.getOccupantType().equals("Batiment")) {
                Batiment batimentAttaque = (Batiment) c.occupant;
                
            }
        }
    }
    
    /**
     * Toutes les unités militaires peuvent attaquer un bâtiment.
     * @param batiment
     * @return boolean
     */
    @Override 
    public final boolean peutAttaquer(Batiment batiment)
    {
        return true;
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
