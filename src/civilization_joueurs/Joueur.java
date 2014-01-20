package civilization_joueurs;

import civilization.game_engine.Game;
import civilization_batiments.*;
import civilization_unites.*;
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Color;

public class Joueur 
{
    public String pseudo;
    public int ressourcesOr;
    public int ressourcesBois;
    public int ressourcesFer;
    public int ressourcesNourriture;
    public Game jeu;
    
    public ArrayList<Batiment> batiments = new ArrayList<>();
    public ArrayList<Unite> unites = new ArrayList<>();
    public ArrayList<UniteCivile> unitesCiviles = new ArrayList<>();
    public ArrayList<UniteMilitaire> unitesMilitaires = new ArrayList<>();
    public String[] pseudosDisponible = new String[]{
        "Honey Bunny", "Smoochy", "Babycake", "Dream Boy", "Dream Girl", "Lovebird", "My Hunk", "Paramour", "Stud", "Sweet Potato", "Squeeze", "Steady", "Stud Muffin", "Sugar Daddy", "Shnookums", "Hottie", "Casanova", "Ducky", "Jaycee", "Star", "Afflon", "Acence", "Abarden", "Alia", "Brodir", "Bydern", "Caino", "Cade", "Burk", "Bolu", "Calden", "Darste", "Daun", "Darrin", "Daud", "Eron", "Falan", "Fayne", "Furl", "Garth", "Gyin", "Hacyon", "Gwydion", "Gwerto", "Gurney", "Kam", "Kenneldor", "Kaprin", "Kern", "Kib", "Layne", "Leit", "Letor", "Leia", "River", "Rosh", "Ruly", "Saeg", "Sathe", "Zymos"
    };
    
    public Color couleur;
        
    /**
     * Crée un joueur avec un pseudo aléatoire.
     */
    public Joueur()
    {
        Random random = new Random();
        this.pseudo = pseudosDisponible[random.nextInt(pseudosDisponible.length-1)];
        this.ressourcesBois = 100;
        this.ressourcesFer = 100;
        this.ressourcesNourriture = 100;
        this.ressourcesOr = 100;
        this.couleur=new Color((float)Math.random(), (float)Math.random(),(float)Math.random());
    }
    
    /**
     * Crée un joueur avec un pseudo.
     * @param _pseudo (required) pseudo du joueur
     */
    public Joueur(String _pseudo)
    {
        this.pseudo = _pseudo;
        this.ressourcesBois = 1000;
        this.ressourcesFer = 1000;
        this.ressourcesNourriture = 1000;
        this.ressourcesOr = 1000;
        this.couleur=new Color((float)Math.random(), (float)Math.random(),(float)Math.random());
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
        this.couleur=new Color((float)Math.random(), (float)Math.random(),(float)Math.random());
    }
    
    /**
     * Crée un joueur avec un pseudo et un jeu.
     * @param _pseudo (required) pseudo du joueur
     * @param g (required) Jeu auquel appartient le joueur
     */
    public Joueur(String _pseudo, Game g)
    {
        this.pseudo = _pseudo;
        this.ressourcesBois = 100;
        this.ressourcesFer = 100;
        this.ressourcesNourriture = 100;
        this.ressourcesOr = 100;
        this.jeu=g;
        this.couleur=new Color((float)Math.random(), (float)Math.random(),(float)Math.random());
    }

    /**
     * Ajoute une unité au joueur
     * @param unite 
     */
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
        
        this.consommerLesRessourcesNecessairesPourConstruire(unite);
    }
    
    /**
     * Ajoute un batiment au joueur
     * @param batiment 
     */
    public void ajouterBatiment(Batiment batiment) 
    {
        this.batiments.add(batiment);     
        this.consommerLesRessourcesNecessairesPourConstruire(batiment);
    }
    
    /**
     * Vérifie que le joueur est en capacité d'acheter une unité
     * @param unite
     * @return boolean
     */
    public boolean disposeDesRessourcesNessairesPourAcheter(Unite unite) 
    {
        return (this.ressourcesOr >= unite.requisOr && this.ressourcesBois >= unite.requisBois && this.ressourcesFer >= unite.requisFer && this.ressourcesNourriture >= unite.requisNourriture);
    }
    
    /**
     * Vérifie que le joueur est en capacité d'acheter un bâtiment
     * @param batiment
     * @return 
     */
    public boolean disposeDesRessourcesNessairesPourAcheter(Batiment batiment)
    {
        return (this.ressourcesOr >= batiment.requisOr && this.ressourcesBois >= batiment.requisBois && this.ressourcesFer >= batiment.requisFer && this.ressourcesNourriture >= batiment.requisNourriture);
    }
    
    /**
     * Consomme les ressources d'un joueur nécessaires à la construction d'une unité
     * @param unite 
     */
    private void consommerLesRessourcesNecessairesPourConstruire(Unite unite) 
    {        
        this.ressourcesBois -= unite.requisBois;
        this.ressourcesFer -= unite.requisFer;
        this.ressourcesNourriture -= unite.requisNourriture;
        this.ressourcesOr -= unite.requisOr;
    }
    
    /**
     * Consomme les ressources d'un joueur nécessaire à la construction d'un bâtiment
     * @param batiment 
     */
    private void consommerLesRessourcesNecessairesPourConstruire(Batiment batiment) 
    {        
        this.ressourcesBois -= batiment.requisBois;
        this.ressourcesFer -= batiment.requisFer;
        this.ressourcesNourriture -= batiment.requisNourriture;
        this.ressourcesOr -= batiment.requisOr;
        
        System.out.println(ressourcesBois+"/"+ressourcesFer+"/"+ressourcesNourriture+"/"+ressourcesOr);
    }
    
    /**
     * Consomme les ressources d'un joueur nécessaires pour la survie d'une unité
     * @param unite 
     */
    private void consommerLesRessourcesNecessairesPourVivre(Unite unite) 
    {
        this.ressourcesBois -= unite.consommeBois;
        this.ressourcesFer -= unite.consommeFer;
        this.ressourcesNourriture -= unite.consommeNourriture;
        this.ressourcesOr -= unite.consommeOr;
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
         * Liste de TOUS les Bâtiments
         */
        str += "    [BATIM]      ("+this.batiments.size()+") ";
        for (Batiment b : this.batiments) {
            str += b.getClass().getSimpleName()+" ";
        }
        str += "\n";
        
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
        str += "    [UNITES MIL] ("+this.unitesMilitaires.size()+") ";
        for (UniteMilitaire um : this.unitesMilitaires) {
            str += um.getClass().getSimpleName()+" ";
        }
        str += "\n";
        
        return str;
    }
}