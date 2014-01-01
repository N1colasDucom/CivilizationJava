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

public abstract class Unite 
{
    public Joueur joueur;
    
    int tempsConstruction;
    int pointsDeVie;
    int defense;
    int niveau;
    
    int requisNourriture;
    int requisBois;
    int requisFer;
    int requisOr;
    int requisNiveau;
    
    int consommeNourriture;
    int consommeBois;
    int consommeFer;
    int consommeOr;

    Case caseParent;
    Batiment batimentParent;
    
    public Unite(Joueur _joueur) {
        this.joueur = _joueur;
        this.joueur.ajouterUnite(this);
        
        this.defense = 1;
        this.niveau = 1;
        
        this.requisNourriture = 0;
        this.requisBois = 0;
        this.requisFer = 0;
        this.requisOr = 0;
        this.requisNiveau = 1;
        
        this.consommeNourriture = 0;
        this.consommeBois = 0;
        this.consommeFer = 0;
        this.consommeOr = 0;
        
        this.caseParent = null;
        this.batimentParent = null;
        
    }
    
    public boolean peutAttaquer(Unite unite)
    {
        return false;

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
        String str = "    [OWN] "+this.joueur.pseudo+"\n";
        str += "    [DEF] 1    [LEV] 1\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " LVL:"+this.requisNiveau+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}