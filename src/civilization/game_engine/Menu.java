/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author Nicolas
 */
public class Menu extends BasicGameState
{
    GameButton Jouer;
    GameButton Quitter;
    Image Background;
    
    public Menu(int State)
    {
        
    }

    
    @Override
    public int getID() 
    {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        Jouer = new GameButton(100,100,new Image("Graphics/Buttons/Jouer.png"));       
        Quitter =new GameButton(100,200,new Image("Graphics/Buttons/Quitter.png"));
        Background = new Image("Graphics/Images/MenuPrincipal.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        Background.draw(0,0);
        Jouer.Image.draw(100, 100);
        Quitter.Image.draw(100, 200);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
       int mouseX=gc.getInput().getMouseX();
       int mouseY=gc.getInput().getMouseY();
       
       if (gc.getInput().isMousePressed(0)) {
           if(Jouer.clickOnMe(mouseX, mouseY)){
              game.enterState(1);
           }
           else if (Quitter.clickOnMe(mouseX, mouseY)){
               gc.exit();
           }
        }
     
          
           
    }

    
}
