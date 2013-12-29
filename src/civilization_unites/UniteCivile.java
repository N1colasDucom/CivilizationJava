package civilization_unites;

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

    public UniteCivile(Joueur joueur) {
        super(joueur);
        this.peutObtenirNourriture = false;
        this.peutObtenirFer = false;
        this.peutObtenirBois = false;
        this.peutTransporter = false;
        this.peutConstruire = false;
    }
    
    @Override public String toString()
    {
        return this.getClass().getSimpleName() + " (" + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
