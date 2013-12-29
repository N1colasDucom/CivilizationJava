package civilization_unites;

import civilization_joueurs.Joueur;
import civilization_exceptions.*;

public abstract class Unite 
{
    public Joueur joueur;
    
    public int tempsConstruction;
    public int pointsDeVie;
    public int defense;
    
    public int requisNourriture;
    public int requisBois;
    public int requisFer;
    public int requisOr;
    
    public int consommeNourriture;
    public int consommeBois;
    public int consommeFer;
    public int consommeOr;

    public Unite(Joueur _joueur, int or, int bois, int fer, int nourriture, int tpsConstruction, int defense) 
    {              
        
        this.requisNourriture = nourriture;
        this.requisBois = bois;
        this.requisFer = fer;
        this.requisOr = or;
        this.tempsConstruction = tpsConstruction;
        this.defense = defense;
        
        this.consommeNourriture = 0;
        this.consommeBois = 0;
        this.consommeFer = 0;
        this.consommeOr = 0;
        
        try {
            if (_joueur.disposeDesRessourcesNessairesPourAcheter(this)) {
                this.joueur = _joueur;
                this.joueur.ajouterUnite(this);
            } else {
                throw new RessourcesInsuffisantesException();
            }
        } catch (RessourcesInsuffisantesException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean peutAttaquer(Unite unite)
    {
        return false;
    }
    
    @Override public String toString()
    {
        String str = "    [OWN] "+this.joueur.pseudo+"\n";
        str += "    [DEF] "+this.defense+"\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}