/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;
import civilization_batiments.Batiment;
import civilization_unites.Unite;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GameButton {
   int X,Y;
   Image Image;
   String action;
   Object parent;
   Method method;
   Constructor construct;

   public GameButton(int x,int y,Image i){
       X=x;
       Y=y;
       Image=i;
       action=null;
   }
   
   public GameButton(int x,int y,Image i,String s,Object p){
       X=x;
       Y=y;
       Image=i;
       action=s;
       parent=p;
   }
   
   public GameButton(int x,int y,Image i,String s, Constructor c,Object p){
       X=x;
       Y=y;
       Image=i;
       action = s;
       construct=c;
       parent=p;
   }
   
   public GameButton(int x,int y,Image i,String s, Method m,Object p){
       X=x;
       Y=y;
       Image=i;
       action = s;
       method=m;
       System.out.println(m);
       parent=p;
   } 
   
      public GameButton(int x,int y,Image i,String s,Method m, Constructor c,Object p){
       X=x;
       Y=y;
       Image=i;
       action = s;
       method=m;
       construct=c;
       parent=p;
   }
   
   /**
    * retourne Vrai le clique a eu lieu sur ce bouton
    * @param mouseX
    * @param mouseY
    * @return 
    */
   public boolean clickOnMe(int mouseX,int mouseY){
       return ((mouseX>X&&mouseX<(X+Image.getWidth()))&(mouseY>Y&&mouseY<(Y+Image.getHeight())))?(true):(false);
   }
   
   public void draw(Graphics g){
       this.Image.draw(this.X, this.Y);
       g.setColor(Color.white);
       if(this.action!=null){
           g.drawString(action, X, Y+10);
       }
   }
   
   /**
    * Appelle l'action liee a ce bouton, que ce soit un affichage de String, une Methode ou un Constructeur
    */
   public void doAction(){
       System.out.println(method);
       if(method!=null && construct!=null){
           try {
               method.invoke(parent,action,construct);
           } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
               Throwable cause = ex.getCause();
               System.out.println(cause);
           } 
       }
       else if(method!=null){
           try {   
               System.out.println(method.getName());
               method.invoke(parent);
           } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
               System.out.println(ex.getCause());
           }         
       }
       else if(construct!=null){
           try {
               System.out.println(construct.getName());
               construct.newInstance(((Batiment)parent).joueur, null, (Batiment)this.parent);
           } catch (InstantiationException |IllegalAccessException| IllegalArgumentException| InvocationTargetException ex) {
               Logger.getLogger(GameButton.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
   }
   
   /**
    * retourne le type d'unite auquel est lie le bouton
    * @return 
    */
   public String getParentType(){
        if(this.parent!=null){
        Class c = parent.getClass();
        while(c!=null){
            if(c.getSimpleName().equals("Unite")) return c.getSimpleName();
            else if(c.getSimpleName().equals("Batiment")) return c.getSimpleName();
            c=c.getSuperclass();
        }}
        return "Erreur Classe Occupant";        
    }
}
