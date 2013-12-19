package civilization_unites;

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

    public UniteCivile() {
        this.peutObtenirNourriture = false;
        this.peutObtenirFer = false;
        this.peutObtenirBois = false;
        this.peutTransporter = false;
        this.peutConstruire = false;
    }
}
