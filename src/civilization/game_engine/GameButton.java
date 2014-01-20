package civilization.game_engine;

import civilization_batiments.Batiment;
import civilization_unites.Unite;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GameButton 
{
   int X,Y;
   Image image, sprite;
   String action;
   Object parent;
   Method method;
   Constructor construct;

   public GameButton(int x,int y,Image i)
   {
       X = x;
       Y = y;
       image = i;
       action = null;
   }
   
   public GameButton(int x,int y,Image i,String s,Object p)
   {
       X = x;
       Y = y;
       image = i;
       action = s;
       parent = p;
   }
   
   public GameButton(int x, int y, Image i, String s, Constructor c, Object p)
   {
       X = x;
       Y = y;
       image = i;
       action = "Test 1";
       construct = c;
       parent = p;
   }
   

   public GameButton(int x, int y, Image i, String s, Constructor c, Image sp, Object p)
   {
       X = x; Y = y;
       image = i;
       action = s; //"Test 2";
       sprite = sp;
       construct = c;
       parent = p;
   }
   
   public GameButton(int x, int y, Image i, String s, Method m, Object p)
   {
       X = x; Y = y;
       image = i;
       action = s; //"Test 3";
       method = m;
       parent = p;
   } 
   
   public GameButton(int x, int y, Image i, String s, Method m, Constructor c, Image sp, Object p)
   {
       X = x;
       Y = y;
       image = i;
       sprite = sp;
       action = s; //"Test 4";
       method = m;
       construct = c;
       parent = p;
   }
   
   /**
    * retourne Vrai le clique a eu lieu sur ce bouton
    * @param mouseX
    * @param mouseY
    * @return 
    */
   public boolean clickOnMe(int mouseX,int mouseY)
   {
       return ((mouseX>X&&mouseX<(X+image.getWidth()))&(mouseY>Y&&mouseY<(Y+image.getHeight())))?(true):(false);
   }
   
   
   public void draw(Graphics g)
   {
       int x = this.X;
       int y= this.Y;
       this.image.draw(x, y);
       g.setColor(Color.black);
       if (this.sprite!=null){
           x+=5;
           y+=0;
           this.sprite.draw(x,y);
           x+=32;
           y+=5;
       }  else {
           x+=10;
           y+=15;
       }
       if(this.action!=null){
           g.drawString(action, x, y);
       }
   }
   
   /**
    * Appelle l'action liee a ce bouton, que ce soit un affichage de String, une Methode ou un Constructeur
    */
   public void doAction()
   {
       System.out.println("YOU SHALL NOT PASS BY VP");
       if (method != null && construct != null) {
           System.out.println("YOU SHALL NOT PASS BY VP_1");
           System.out.println((Unite)parent);
           try {
               method.invoke(parent, action, construct, (Unite)parent);
           } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
               Throwable cause = ex.getCause();
               System.out.println(cause);
           }
           
       } else if (method!=null) {
           System.out.println("YOU SHALL NOT PASS BY VP_2");
           try {   
               System.out.println(method.getName());
               method.invoke(parent);
           } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
               System.out.println(ex.getCause());
           } 
           
       } else if (construct != null) {
           System.out.println("YOU SHALL NOT PASS BY VP_3");
           try {
               if (parent.getClass().getSuperclass().getSimpleName().contains("Unite")) {
                   Batiment batimentConstruit = (Batiment) construct.newInstance(((Unite)parent).joueur, ((Unite)this.parent).caseParent);
                   System.out.println(batimentConstruit);
               } else {
                   Unite uniteConstruite = (Unite) construct.newInstance(((Batiment)parent).joueur, null, (Batiment)this.parent);
                   System.out.println(uniteConstruite);
               }  
           } catch (InstantiationException |IllegalAccessException| IllegalArgumentException| InvocationTargetException ex) {
               Logger.getLogger(GameButton.class.getName()).log(Level.SEVERE, null, ex);
           }
       }  
   }
   
   /**
    * retourne le type d'unite auquel est lie le bouton
    * @return 
    */
   public String getParentType()
   {
        if(this.parent!=null) {
            Class c = parent.getClass();
            while (c != null) {
                if (c.getSimpleName().equals("Unite")) {
                    return c.getSimpleName();
                } else if (c.getSimpleName().equals("Batiment")) {
                    return c.getSimpleName();
                }
                c=c.getSuperclass();
            }
        }
        
        return "Erreur Classe Occupant";        
    }
   
   public boolean actionDejaRealisee()
   {
       switch(this.getParentType()){
           case "Unite":       
               return ((Unite)this.parent).actionDuTourRealisee;
           case "Batiment":    
               return ((Batiment)this.parent).actionDuTourRealisee;
       }
       return false;
   }
}
