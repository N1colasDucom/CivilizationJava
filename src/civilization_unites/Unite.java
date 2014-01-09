package civilization_unites;

import civilization.Case;
import civilization.game_engine.GameButton;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import civilization_exceptions.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Unite 
{
    public Joueur joueur;
    
    public String nom, statut;
  
    Case caseParent;
    Batiment batimentParent;

    public int pointsDeVie, defense, distanceDeMvt;
    public int requisNourriture, requisBois, requisFer, requisOr, tempsConstruction;
    public int consommeNourriture, consommeBois, consommeFer, consommeOr;
        
    public Unite(Joueur _joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
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
        
        this.caseParent = null;
        this.batimentParent = null;
        
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
    
    public void setCaseParent(Case c){
        if (this.caseParent!=null) {
            this.caseParent.occupant=null;
        }      
        this.caseParent=c;
        this.caseParent.occupant=this;
    }
    
    public void setBatimentParent(Batiment b){
        this.caseParent.occupant=null;
        this.caseParent=null;
        this.batimentParent=b;
    }
    
    public void deplacer(Case nvCase){
        setCaseParent(nvCase);
    }
    
    public int positionX(){
        return this.caseParent.X;
    }
    
    public int positionY(){
        return this.caseParent.Y;
    }
    
    public List<GameButton> getMenu(){
      List<GameButton> list = new ArrayList<>();
        try {
            list.add(new GameButton(810, 100, new Image("Graphics/Buttons/Deplacer.png"), "deplacer",this));
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
      return list;
    }
    
    public Image getSprite(){
        try {
            return new Image("Graphics/Units/Unites/"+this.getClass().getSimpleName()+"/sprite.png");
        } catch (SlickException ex) {
            System.out.println("Erreur image:"+this.getClass().getSimpleName());
        }
        return null;
    }
    
    @Override public String toString()
    {
        String str = "";
        str += "    [OWN] "+this.joueur.pseudo+"\n";
        str += "    [DEF] "+this.defense+"\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}