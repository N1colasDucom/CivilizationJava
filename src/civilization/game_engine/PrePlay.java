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
public class PrePlay extends BasicGameState
{
    GameButton randomMap, startGame, quitGame;
    Image Background, map;
    StateBasedGame game;
    
    PrePlay(int state) 
    {
        
    }

    
    @Override
    public int getID() 
    {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game=game;
        randomMap = new GameButton(578, 378, new Image("Graphics/Images/Bouton.png"));
        startGame = new GameButton(622, 464, new Image("Graphics/Images/Bouton.png"));
        quitGame = new GameButton(678, 548, new Image("Graphics/Images/Bouton.png"));
        Game.plateau= civilization.game_engine.mapgenerator.Noise.GenerateMap();
        map = new Image("Graphics/Tileset/gameMap.png");
        Background = new Image("Graphics/Images/MenuSecondaire.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        map.draw(162, 335, 3);
        Background.draw(0, 0);
        randomMap.Image.draw(578, 378);
        startGame.Image.draw(622, 464);
        quitGame.Image.draw(678, 548);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
       int mouseX=gc.getInput().getMouseX();
       int mouseY=gc.getInput().getMouseY();
            if (gc.getInput().isMousePressed(0)) {
           if(randomMap.clickOnMe(mouseX, mouseY)){
             Game.plateau=civilization.game_engine.mapgenerator.Noise.GenerateMap(); 
             map.destroy();
             map = new Image("Graphics/Tileset/gameMap.png");
              
           }
           else if(startGame.clickOnMe(mouseX, mouseY)){
             
              game.enterState(2);
           }
        }
    }
    
}
