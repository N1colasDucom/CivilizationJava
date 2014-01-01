/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import civilization.Plateau;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Nicolas
 */
public class PrePlay extends BasicGameState{
    
    GameButton randomMap;
    GameButton startGame;
    Image map;
    StateBasedGame game;
    
    PrePlay(int state) {
        
    }

    
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game=game;
        randomMap = new GameButton(100, 100, new Image("Graphics/Buttons/Generer.png"));
        startGame = new GameButton(100, 200, new Image("Graphics/Buttons/Jouer.png"));
      //  Game.plateau= civilization.game_engine.mapgenerator.Noise.GenerateMap();
       // map = new Image("Graphics/Tileset/gameMap.png");
       
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        randomMap.Image.draw(100, 100);
        startGame.Image.draw(100,200);
      //  map.draw(200,100);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
       int mouseX=gc.getInput().getMouseX();
       int mouseY=gc.getInput().getMouseY();
            if (gc.getInput().isMousePressed(0)) {
           if((mouseX>randomMap.X && mouseX<randomMap.X+randomMap.Image.getWidth())&&(mouseY>randomMap.Y && mouseY<randomMap.Y+randomMap.Image.getHeight())){
             //Game.plateau=civilization.game_engine.mapgenerator.Noise.GenerateMap(); 
            // map.destroy();
            // map = new Image("Graphics/Tileset/gameMap.png");
              
           }
           else if((mouseX>startGame.X && mouseX<startGame.X+startGame.Image.getWidth())&&(mouseY>startGame.Y && mouseY<startGame.Y+startGame.Image.getHeight())){
             
              game.enterState(2);
           }
        }
    }
    
}
