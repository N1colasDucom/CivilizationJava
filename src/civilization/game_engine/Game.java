/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Nicolas
 */
public class Game extends StateBasedGame{
    public static final String gameName = "Civilisation";
    public static final int play = 1;
     public static final int menu = 0;
    
    
    public Game(String name) {
        super(gameName);
        
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        
    }
    
}
