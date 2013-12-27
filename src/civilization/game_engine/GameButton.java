/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GameButton {
   int X,Y;
   Image Image;

   public GameButton(int x,int y,Image i){
       X=x;
       Y=y;
       Image=i;
   }
}
