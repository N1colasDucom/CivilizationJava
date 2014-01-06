package civilization_unites;

import civilization_joueurs.Joueur;
import civilization_exceptions.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Unite 
{
    public Joueur joueur;
    
    public String nom, statut;
    
    public int pointsDeVie, defense, distanceDeMvt;
    public int requisNourriture, requisBois, requisFer, requisOr, tempsConstruction;
    public int consommeNourriture, consommeBois, consommeFer, consommeOr;
        
    public Map<String, Integer> coords = new HashMap<>();

    public Unite(Joueur _joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int coordX, int coordY,
            int dist) 
    {              
        this.nom = nom;
        
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
        
        this.coords.put("x", coordX);
        this.coords.put("y", coordY);
        
        this.distanceDeMvt = dist;
        this.statut = "En cours de création...";
                
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
        if (this.equals(unite)) {
            return false;
        } else if (unite.joueur.equals(this)) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override public String toString()
    {
        String str = "";
        str += "    [OWN] "+this.joueur.pseudo+"\n";
        str += "    [POS] ("+this.coords.get("x")+"; "+this.coords.get("y")+")\n";
        str += "    [DEF] "+this.defense+"\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}