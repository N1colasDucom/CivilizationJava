/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import civilization.Case;
import civilization.Plateau;
import civilization.game_engine.mapgenerator.ImageWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;

/**
 *
 * @author Nicolas
 */
public class Play extends BasicGameState{
    private TiledMap tMap=null;
    private Image elf,elf2;
    int tMapX=0,tMapY=0;
    static int WSizeX=1000,WSizeY=800;
    int realMouseX=0,realMouseY=0;
    int[] square;
    private List<int[]> movableTiles=null;
    
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
    
    public void writeType(int x, int y){
        System.out.println(Game.plateau.cases.size());
        System.out.println(Game.plateau.cases.get(y-1).size());
        System.out.println(Game.plateau.cases.get(y-1).get(x-1).type());
        System.out.println(Game.plateau.cases.get(y-1).get(x-1).typeCase);
    }
    
    public void writeArrayListCases() throws IOException{
        FileWriter fstream = null;
        try {
            fstream = new FileWriter("test2.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(ImageWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter out = new BufferedWriter(fstream);
        int i=0,j=0;
            
        for(i=1;i<=100;i++){
            for(j=1;j<=100;j++){
                out.write(Integer.toString(Game.plateau.cases.get(i-1).get(j-1).typeCase));
            }
            out.write("\n");
        }
        out.close();
    }
    
    public void setMap() throws SlickException{
        tMap = new TiledMap("Graphics/Tileset/map.tmx");       
    }
    
    public void setMovableTiles(int x, int y,int l){
        int xStart,yStart,xFinish,yFinish;
        if(this.movableTiles!=null)this.movableTiles.clear(); 
        this.movableTiles = new ArrayList<>();
        int[] tiles=null;
        xStart=(x-l>0)?(x-l):1;
        yStart=(x-l>0)?(y-l):1;
        xFinish=(x+l<tMap.getWidth())?(x+l):100;
        yFinish=(y+l<tMap.getHeight())?(y+l):100;
        System.out.println(xStart+" "+xFinish);
        System.out.println(yStart+" "+yFinish);
        for(int i=xStart;i<=xFinish;i++){
            for(int j=yStart;j<=yFinish;j++){
                if((Math.abs(x-i)+Math.abs(y-j))<=l){
                    tiles=new int[2];
                    tiles[0]=i;
                   tiles[1]=j;
                    this.movableTiles.add(tiles);
                    tiles=null;
                }
            }
        }
        printMovableTiles();
    }
    
    public void printMovableTiles(){
        System.out.println("Movable:");
        System.out.println("Empty:"+this.movableTiles.isEmpty());
        System.out.println("Size:"+this.movableTiles.size());
    }
    
    public void drawMovableTiles(Graphics g){
        Color Fill = new Color(0.5f, 0.5f, 0.5f, 0.5f);        
        for(int i=0;i<this.movableTiles.size();i++){
          g.fillRect((float)(this.movableTiles.get(i)[0]*32-32*tMapX-32),(float)(this.movableTiles.get(i)[1]*32-32*tMapY-32), 30, 30);
       }
       
    }
    
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
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
        if(this.movableTiles!=null){
            this.drawMovableTiles(g);
        }
                
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        if(this.tMap==null){
            this.setMap();
        }
        if (gc.getInput().isMousePressed(0)) {
        realMouseX=(gc.getInput().getMouseX()+tMapX*tMap.getTileWidth())/tMap.getTileWidth()+1;
        realMouseY=(gc.getInput().getMouseY()+tMapY*tMap.getTileHeight())/tMap.getTileHeight()+1;
        System.out.println("Mouse  :"+realMouseX+" "+realMouseY);
        square=null;
        square=new int[]{realMouseX, realMouseY};
        this.setMovableTiles(realMouseX, realMouseY, 4);
        this.writeType(realMouseX, realMouseY);
                try {
                    writeArrayListCases();
                } catch (IOException ex) {
                    Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
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
