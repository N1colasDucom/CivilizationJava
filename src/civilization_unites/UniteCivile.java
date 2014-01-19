package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public abstract class UniteCivile extends Unite
{
    boolean peutConstruire;
    boolean peutObtenirNourriture;
    boolean peutObtenirFer;
    boolean peutObtenirBois;
    boolean peutObtenirOr = false;
    boolean peutTransporter;
    
    int produitNourriture;
    int produitBois;
    int produitFer;
    int produitOr;
    
    /**
     * Construit une Unité Civile (hériant d'Unité).
     * @param joueur Propriétaire de l'unité
     * @param nom Nom de l'unité
     * @param or Quantité d'or requise
     * @param bois Quantité de bois requise
     * @param fer Quantité de fer requise
     * @param nourriture Quantité de nourriture requise
     * @param tpsConstruction Temps de construction requis
     * @param defense Points de défense
     * @param dist Distance d'attaque
     * @param caseParent Case qui contient l'unité
     * @param batimentParent Bâtiment qui contient l'unité
     * @param ptVie Points de vie
     */
    public UniteCivile(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie,
            int prodOr, int prodBois, int prodFer, int prodNourr
    ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie, prodOr, prodBois, prodFer, prodNourr);
    }
    
    /**
     * Une unité civile ne peut pas attaquer d'unité.
     * @param unite
     * @return boolean
     */
    @Override 
    public final boolean peutAttaquer(Unite unite)
    {
        return false;
    }
    
    /**
     * Une unité civile ne peut pas attaquer de bâtiment.
     * @param batiment
     * @return boolean
     */
    @Override 
    public final boolean peutAttaquer(Batiment batiment)
    {
        return false;
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
