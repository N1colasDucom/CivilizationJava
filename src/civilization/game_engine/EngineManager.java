/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import org.lwjgl.input.Cursor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageData;

/**
 *
 * @author Nicolas
 */
public class EngineManager {
    Engine eng;
    
    public EngineManager(){
           
    }
    
    public void startEngine(){
        eng = new Engine("Civilisation");
    }
    
}
