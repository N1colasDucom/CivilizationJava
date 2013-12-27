/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Nicolas
 */
public class Play extends BasicGameState{
    private TiledMap tMap;
    int tMapX=0,tMapY=0;
    static int WSizeX=30*36,WSizeY=20*36;
    int realMouseX=0,realMouseY=0;
    public Play(int State){
        
    }
    
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        tMap = new TiledMap("Graphics/Tileset/map.tmx");
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        tMap.render(0,0, tMapX, tMapY,10,10);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        if( gc.getInput().isKeyDown(Input.KEY_RIGHT) )
		{
			if((WSizeX+tMapX*tMap.getTileWidth())<(tMap.getWidth()*tMap.getTileWidth())) tMapX++;
		}
 
		if( gc.getInput().isKeyDown(Input.KEY_LEFT) )
		{
			if(tMapX>0) tMapX--;
		}
		if( gc.getInput().isKeyDown(Input.KEY_UP) )
		{
			
                    if(tMapY>0) tMapY--;
		}
 
		if( gc.getInput().isKeyDown(Input.KEY_DOWN) )
		{
			if((WSizeY+tMapY*tMap.getTileHeight())<(tMap.getTileHeight()*tMap.getHeight())) tMapY++;
		}
    }
    
}
