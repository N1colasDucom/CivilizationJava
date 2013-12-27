/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
    private Image elf,elf2;
    int tMapX=0,tMapY=0;
    static int WSizeX=1000,WSizeY=800;
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
        elf = new Image("Graphics/Units/Dark Elf/Blind.png");
        elf2 = new Image("Graphics/Units/Dark Elf/Blind.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        tMap.render(0,0, tMapX, tMapY,25,20);
        elf.draw((float)(20*32-32*tMapX),(float)(20*32-32*tMapY),(float)32,(float)32);
        if (((99*32-32*tMapX<25*32)&&(99*32-32*tMapY<20*32))) {
           elf2.draw((float)(99*32-32*tMapX),(float)(99*32-32*tMapY),(float)32,(float)32); 
        }
        
                
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        if( gc.getInput().isKeyDown(Input.KEY_RIGHT) )
		{
			if(tMapX+25<tMap.getWidth()) tMapX++;
                        //System.out.println("test : elf x + location x: "+(99*32-32*tMapX));
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
                if(tMapY+20<tMap.getHeight()) tMapY++;
                    
		}
    }
    
}
