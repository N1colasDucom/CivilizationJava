package civilization_batiments;

import civilization.Case;
import civilization.game_engine.GameButton;
import civilization_exceptions.RessourcesInsuffisantesException;
import civilization_joueurs.Joueur;
import civilization_unites.UCT_Ouvrier;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class Batiment 
{    
    public Joueur joueur;
    public int pointsDeVie, pointsDeVieRestants;
    public int requisNourriture, requisBois, requisFer, requisOr, prodOr, prodBois, prodFer, prodNourriture, tempsConstruction, ouvriersMax;
    public ArrayList<UCT_Ouvrier> ouvriersQuiConstruisent = new ArrayList<>();
    public Case caseParent;
    
    public abstract Map<String, Constructor> getConstructions();
    public abstract Map<String, Method> getActions();
        
    public Batiment(
            Joueur j, Case c, int t, int p,
            int or, int bois, int fer, int nourriture, int ouvriersMax,
            int prodOr, int prodBois, int prodFer, int prodNourriture
    ) {
        this.pointsDeVie = p;
        this.pointsDeVieRestants = this.pointsDeVie;
        this.requisOr = or;
        this.requisBois = bois;
        this.requisFer = fer;
        this.requisNourriture = nourriture;
        this.prodOr = prodOr;
        this.prodBois = prodBois;
        this.prodFer = prodFer;
        this.prodNourriture = prodNourriture;
        this.ouvriersMax = ouvriersMax;
        this.tempsConstruction = t;
       
       try {
            if (j.disposeDesRessourcesNessairesPourAcheter(this)) {
                this.joueur = j;
                this.joueur.ajouterBatiment(this);
                this.caseParent = c;
                this.caseParent.occupant = this;
            } else {
                throw new RessourcesInsuffisantesException();
            }
        } catch (RessourcesInsuffisantesException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean reparer()
    {
        System.out.println("REPARATION DE : \n" + this.toString());
        return true;
    }
    
    public boolean detruire()
    {
        this.caseParent.occupant = null;
        this.joueur.batiments.remove(this);
        return true;
    }
    
    /**
     * Ajoute les ressources produits par un batiment à un joueur.
     * @param joueur 
     */
    public void produireDesRessources(Joueur joueur)
    {
        joueur.ressourcesOr += this.prodOr;
        joueur.ressourcesBois += this.prodBois;
        joueur.ressourcesFer += this.prodFer;
        joueur.ressourcesNourriture += this.prodNourriture;
    }
    
    /**
     * retourne la Sprite du batiment
     * @return 
     */
    public Image getSprite()
    {
        try {
            return new Image("Graphics/Units/Batiments/"+this.getClass().getSimpleName()+"/sprite.png");
        } catch (SlickException ex) {
            System.out.println("Erreur image:"+this.getClass().getSimpleName());
        }
        
        return null;
    }
    
    /**
     * Attribue une case parent a un batiment
     * @param c 
     */
    public void setCaseParent(Case c)
    {
        if (this.caseParent!=null) {
            this.caseParent.occupant=null;
        }      
        this.caseParent=c;
        this.caseParent.occupant=this;
        System.out.println(this.getClass().getSimpleName());
    }
    
        /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionX()
    {
        return this.caseParent.X;
    }
    
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionY()
    {
        return this.caseParent.Y;
    }
    
    /**
     * retourne une liste de boutons correspondant aux actions que peut effectuer ce batiment
     * @return 
     */
    public List<GameButton> getMenu()
    {
      List<GameButton> list = new ArrayList<>();
      int posY=100;
        try {
            for(Constructor c : this.getConstructions().values()){
               // System.out.println(c.getName());
                list.add(new GameButton(810, posY, new Image("Graphics/Units/Unites/"+c.getName().substring(c.getName().lastIndexOf(".")+1)+"/sprite.png"),c.getName().substring(c.getName().lastIndexOf(".")+1),c,this));
                posY+=50;
            }
          for (Method m : this.getActions().values()) {
             // System.out.println(m.getName());
              list.add(new GameButton(810, posY, new Image("Graphics/Buttons/"+m.getName()+".png"),m.getName(),m,this));
              posY+=50;
          }
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
      return list;
    }
}