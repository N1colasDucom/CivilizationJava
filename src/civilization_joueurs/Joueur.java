package civilization_joueurs;

import civilization_batiments.*;
import civilization_unites.*;
import java.util.ArrayList;
import java.util.Random;

public class Joueur 
{
    public String pseudo;
    public int ressourcesOr;
    public int ressourcesBois;
    public int ressourcesFer;
    public int ressourcesNourriture;
    
    public ArrayList<Batiment> batiments = new ArrayList<>();
    public ArrayList<Unite> unites = new ArrayList<>();
    public ArrayList<UniteCivile> unitesCiviles = new ArrayList<>();
    public ArrayList<UniteMilitaire> unitesMilitaires = new ArrayList<>();
    
    /**
     * Crée un joueur avec un pseudo aléatoire.
     */
    public Joueur()
    {
        Random random = new Random();
        this.pseudo = "Joueur_"+random.nextInt(420);
        this.ressourcesBois = 100;
        this.ressourcesFer = 100;
        this.ressourcesNourriture = 100;
        this.ressourcesOr = 100;
    }
    
    /**
     * Crée un joueur avec un pseudo.
     * @param _pseudo (required) pseudo du joueur
     */
    public Joueur(String _pseudo)
    {
        this.pseudo = _pseudo;
        this.ressourcesBois = 100;
        this.ressourcesFer = 100;
        this.ressourcesNourriture = 100;
        this.ressourcesOr = 100;
    }
    
    /**
     * Crée un joueur avec un pseudo et des ressources personnalisées.
     * @param _pseudo (required) pseudo du joueur
     * @param _or (requires) ressources en or
     * @param _bois (required) ressources en bois
     * @param _fer (required) ressources en fer
     * @param _nourriture (required) ressources en nourriture
     */
    public Joueur(String _pseudo, int _or, int _bois, int _fer, int _nourriture)
    {
        this.pseudo = _pseudo;
        this.ressourcesOr = _or;
        this.ressourcesBois = _bois;
        this.ressourcesFer = _fer;
        this.ressourcesNourriture = _nourriture;
    }

    public void ajouterUnite(Unite unite)
    {
        this.unites.add(unite);
        switch (unite.getClass().getSuperclass().getSuperclass().getSimpleName()) {
            case "UniteCivile":
                this.unitesCiviles.add((UniteCivile) unite);
                break;
            case "UniteMilitaire":
                this.unitesMilitaires.add((UniteMilitaire) unite);
                break;
        }
    }
    
    public void ajouterBatiment(Batiment aThis) 
    {
        //TODO Par Nico
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override public String toString()
    {
        String str = "";
        str += this.pseudo+" :\n";
        
        /*
         * Liste des Ressources
         */
        str += "    [RESS]       BOIS:"+this.ressourcesBois+"  NOUR:"+this.ressourcesNourriture+"  FER:"+this.ressourcesFer+"  OR:"+this.ressourcesOr+"\n";
        
        /*
         * Liste de TOUTES les Unités
         */
        str += "    [UNITES]     ("+this.unites.size()+") ";
        for (Unite u : this.unites) {
            str += u.getClass().getSimpleName()+" ";
        }
        str += "\n";
        
        /*
         * Liste des Unités CIVILES
         */
        str += "    [UNITES CIV] ("+this.unitesCiviles.size()+") ";
        for (UniteCivile uc : this.unitesCiviles) {
            str += uc.getClass().getSimpleName()+" ";
        }
        str += "\n";
        
        /*
         * Liste des Unités MILITAIRES
         */
        str += "    [UNITES MIL] ("+this.unitesMilitaires.size()+")";
        for (UniteMilitaire um : this.unitesMilitaires) {
            str += um.getClass().getSimpleName()+" ";
        }
        str += "\n";
        
        return str;
    }
}