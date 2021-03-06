package civilization.game_engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

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
    public void init(GameContainer gc, StateBasedGame game) throws SlickException 
    {
        Jouer = new GameButton(434, 362, new Image("Graphics/Images/Bouton.png"),"Jouer",null);       
        Quitter = new GameButton(434, 448, new Image("Graphics/Images/Bouton.png"),"Quitter",null);
        Background = new Image("Graphics/Images/MenuPrincipal.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException 
    {
        Background.draw(0,0);
        Jouer.draw(g);
        Quitter.draw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException 
    {
       int mouseX=gc.getInput().getMouseX();
       int mouseY=gc.getInput().getMouseY();
       
       if (gc.getInput().isMousePressed(0)) {
           if(Jouer.clickOnMe(mouseX, mouseY)){
              game.enterState(Game.prePlay);
           }
           else if (Quitter.clickOnMe(mouseX, mouseY)){
               gc.exit();
           }
        }   
    }   
}
