/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import java.util.Arrays;
import org.newdawn.slick.Color;
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
    int[] square;
    public Play(int State){
        
    }
    
    public void drawGrid(Graphics g){
       g.setColor(Color.black);
       for(int i=0;i<=25;i++){
       g.drawLine(32*i, 0, 32*i, 640);      
       }
       for(int i=0;i<=20;i++){
       g.drawLine(0,32*i,800,32*i);
       }    
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
        drawGrid(g);
        if(square!=null){
        Color Trans = new Color(1f, 1f, 1f, 0.5f);
        g.setColor(Trans);      
        g.drawRect((float)(square[0]*32-32*tMapX-32+1),(float)(square[1]*32-32*tMapY-32+1), 30, 30);
        }
                
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
                           if (gc.getInput().isMousePressed(0)) {
                       realMouseX=(gc.getInput().getMouseX()+tMapX*tMap.getTileWidth())/tMap.getTileWidth()+1;
                       realMouseY=(gc.getInput().getMouseY()+tMapY*tMap.getTileHeight())/tMap.getTileHeight()+1;
                       System.out.println("Mouse  :"+realMouseX+" "+realMouseY);
                       square=null;
                       square=new int[]{realMouseX, realMouseY};
                       
            }
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
