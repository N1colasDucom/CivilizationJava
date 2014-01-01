/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;
import civilization_unites.Unite;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GameButton {
   int X,Y;
   Image Image;
   String action;
   Object parent;

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
   
   public boolean clickOnMe(int mouseX,int mouseY){
       return ((mouseX>X&&mouseX<(X+Image.getWidth()))&(mouseY>Y&&mouseY<(Y+Image.getHeight())))?(true):(false);
   }
   
   public void doAction(){
       System.out.println(this.action+"{}{}{}{}{}"+this.parent.getClass().getSimpleName());
       
   }
   
   public String getOccupantType(){
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
