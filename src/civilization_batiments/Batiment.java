package civilization_batiments;

import civilization.Case;
import civilization.game_engine.GameButton;
import civilization_joueurs.Joueur;
import civilization_unites.Unite;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Batiment 
{    
    public Joueur joueur;
    public int pointsDeVie;
    public int tempsConstruction;
    
    public Case caseParent;
        
    public void Batiment(Joueur j)
    {
       this.joueur = j;
       this.joueur.ajouterBatiment(this);
    }
    
    public abstract Map<String, Constructor> getConstructions();
    public abstract Map<String, Method> getActions();
    
    public boolean reparer()
    {
        System.out.println("REPARATION DE : \n" + this.toString());
        return true;
    }
    public boolean detruire()
    {
        System.out.println("DESTRUCTION DE : \n" + this.toString());
        return true;
    }
    
    /**
     * retourne la Sprite du batiment
     * @return 
     */
    public Image getSprite(){
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
    public void setCaseParent(Case c){
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
    public int positionX(){
        return this.caseParent.X;
       
    }
    
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionY(){
        return this.caseParent.Y;
    }
    
        /**
     * retourne une liste de boutons correspondant aux actions que peut effectuer ce batiment
     * @return 
     */
    public List<GameButton> getMenu(){
      List<GameButton> list = new ArrayList<>();
      int posY=100;
        try {
            for(Constructor c : this.getConstructions().values()){
               // System.out.println(c.getName());
                list.add(new GameButton(810, posY, new Image("Graphics/Units/Unites/"+c.getName().substring(c.getName().lastIndexOf(".")+1)+"/sprite.png"),c.getName(),c,this));
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

