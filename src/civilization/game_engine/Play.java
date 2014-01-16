/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine;

import civilization.Case;
import civilization.Plateau;
import civilization.game_engine.mapgenerator.ImageWriter;
import civilization.game_engine.pathfinder.AStar;
import civilization_batiments.*;
import civilization_unites.*;
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
import org.newdawn.slick.util.pathfinding.*;

/**
 *
 * @author Nicolas
 */
public class Play extends BasicGameState{
    Aeroport unAeroport, unAeroport2;
    UMT_Artillerie uneArtillerie;
    Port unPort;
    
    public static TiledMap tMap=null;
    int tMapX=0,tMapY=0;
    static int WSizeX=1000,WSizeY=800;
    int realMouseX=0,realMouseY=0;
    int[] square;
    public static List<int[]> movableTiles=null;
    private List<GameButton> actionButtons;
    public static String state;
    public static Case pastTile;
    
    public Play(int State){
        
    }
    
    public void setMovableTiles(List<int[]> mt){
        movableTiles=mt;
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
    
    public void clickInTile(GameContainer gc){
        this.actionButtons.clear();
        System.out.println(Game.j1.batiments.size());
        if(Game.plateau.getCase(realMouseX, realMouseY).occupant!=null){ 
            this.actionButtons=Game.plateau.getCase(realMouseX, realMouseY).getOccupantMenu();       
            state="unite";
        }
    }
    
    public void drawActionMenu(Graphics g){        
        for(int i=0;i<this.actionButtons.size();i++){
            (this.actionButtons.get(i).Image).draw(this.actionButtons.get(i).X, this.actionButtons.get(i).Y);            
          }
    }
    
    public void drawUnits(Graphics g){
        if(!Game.j1.unites.isEmpty()){
            for(int i=0;i<Game.j1.unites.size();i++){   
                if(!Game.j1.unites.get(i).statut.equals("construction")){
                    if ((((Game.j1.unites.get(i).positionX())*32-32*tMapX<25*32)&&(Game.j1.unites.get(i).positionY()*32-32*tMapY<20*32))) {
                        Game.j1.unites.get(i).getSprite().draw((float)(Game.j1.unites.get(i).positionX()*32-32*tMapX),(float)(Game.j1.unites.get(i).positionY()*32-32*tMapY),(float)32,(float)32);
                    }
                }
            }
        }
    }
    
    public void drawBuildings(Graphics g){
        if(!Game.j1.batiments.isEmpty()){
            for(int i=0;i<Game.j1.batiments.size();i++){   
                if ((((Game.j1.batiments.get(i).positionX())*32-32*tMapX<25*32)&&(Game.j1.batiments.get(i).positionY()*32-32*tMapY<20*32))) {
                    Game.j1.batiments.get(i).getSprite().draw((float)(Game.j1.batiments.get(i).positionX()*32-32*tMapX),(float)(Game.j1.batiments.get(i).positionY()*32-32*tMapY),(float)32,(float)32);
                }
            }
        }
    }
    
    public boolean clickInMap(GameContainer gc){
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        return ((x>0&&x<tMap.getTileWidth()*25)&&(y>0&&y<tMap.getTileHeight()*20))?true:false;
    }
    
    public void getClickInGameButton(GameContainer gc){
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        for(int i=0;i<this.actionButtons.size();i++){
            if(this.actionButtons.get(i).clickOnMe(x, y)){
                this.actionButtons.get(i).doAction();
            }
        }
    }
    
    public boolean clickInSideMenu(GameContainer gc){
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        return ((x>tMap.getTileWidth()*25&&x<WSizeX)&&(y>0&&y<tMap.getTileHeight()*20))?true:false;
    }
    
    public boolean clickInBottomPane(GameContainer gc){
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        return ((x>0&&x<tMap.getTileWidth()*25)&&(y>tMap.getTileHeight()*20&&x<WSizeY))?true:false;
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
    
    public void printMovableTiles(){
        System.out.println("Movable:");
        System.out.println("Empty:"+this.movableTiles.isEmpty());
        System.out.println("Size:"+this.movableTiles.size());
        for(int[] tile:movableTiles){
            System.out.println("Tiles");
        }  
    }
    
    public boolean isMovable(int[] tile){
        for(int[] tileTemp:movableTiles){
            System.out.println(tileTemp[0]+":"+tileTemp[1]+"/"+tile[0]+":"+tile[1]);
            if(tileTemp[0]==tile[0]&&tileTemp[1]==tile[1]) return true;
        }  
        return false;
    }
    
    public void drawMovableTiles(Graphics g){
        Color Fill = new Color(0.5f, 0.5f, 0.5f, 0.5f);        
        for(int i=0;i<this.movableTiles.size();i++){
            if ((((this.movableTiles.get(i)[0]-1)*32-32*tMapX<25*32)&&((this.movableTiles.get(i)[1]-1)*32-32*tMapY<20*32))) {
          g.fillRect((float)(this.movableTiles.get(i)[0]*32-32*tMapX-31),(float)(this.movableTiles.get(i)[1]*32-32*tMapY-31), 31, 31);
          }
       } 
    }
    
    public void deplacer(GameContainer gc){
        int[] tileTemp= new int[2];
        tileTemp[0]=realMouseX;
        tileTemp[1]=realMouseY;
        if(state.equals("Deplacement")&&isMovable(tileTemp)){
            ((Unite)pastTile.occupant).deplacer(Game.plateau.getCase(realMouseX, realMouseY));
            if(movableTiles!=null){
            movableTiles.clear();}
        }
        else{
            if(movableTiles!=null){
            movableTiles.clear();}
            state="normal";
            System.out.println("Deplacer : "+state);
        }
    }
    
    public void updatePastTile(GameContainer gc){
        pastTile=Game.plateau.getCase(realMouseX, realMouseY);
    }
    
    public void moveMap(GameContainer gc){
        if( gc.getInput().isKeyDown(Input.KEY_RIGHT) )
        {
            if(tMapX+25<tMap.getWidth()) tMapX++;
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
    
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
         this.actionButtons = new ArrayList<>();  
         movableTiles= new ArrayList<>();
         System.out.println(Game.j1);
         state="normal";
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        tMap.render(0,0, tMapX, tMapY,25,20);
       
        drawGrid(g);
        if(square!=null){
        Color Trans = new Color(1f, 1f, 1f, 0.5f);
        g.setColor(Trans);      
        g.drawRect((float)(square[0]*32-32*tMapX-32+1),(float)(square[1]*32-32*tMapY-32+1), 30, 30);
        }
        if(this.movableTiles!=null){
            this.drawMovableTiles(g);
        }
       if(this.actionButtons.size()!=0){
           drawActionMenu(g);
       }
       
           this.drawUnits(g);
           this.drawBuildings(g);
       
                
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        GameButton gb;
        if(this.tMap==null){
            this.setMap();
        }
        if (gc.getInput().isMousePressed(0)) {
           
        realMouseX=(gc.getInput().getMouseX()+tMapX*tMap.getTileWidth())/tMap.getTileWidth()+1;
        realMouseY=(gc.getInput().getMouseY()+tMapY*tMap.getTileHeight())/tMap.getTileHeight()+1;
        System.out.println("Mouse  :"+gc.getInput().getMouseX()+" "+gc.getInput().getMouseY());
        
        if(clickInMap(gc)){
           
            square=null;
        square=new int[]{realMouseX, realMouseY};
        //this.setMovableTiles(realMouseX, realMouseY, 8);
            System.out.println(Game.plateau.getCase(realMouseX, realMouseY).toString());
            System.out.println(Game.j1.unites.size());
            this.clickInTile(gc);
            deplacer(gc);
            updatePastTile(gc);
            if(pastTile!=null){
            if(realMouseX!=pastTile.X||realMouseY!=pastTile.Y)  System.out.println("("+realMouseX+":"+realMouseY+")("+pastTile.X+":"+pastTile.Y+")");
            }
            
        }
        if(clickInBottomPane(gc)){
            unAeroport=new Aeroport(Game.j1);
            unAeroport.setCaseParent(Game.plateau.getCase(50, 50));
            unAeroport2=new Aeroport(Game.j1);
            unAeroport2.setCaseParent(Game.plateau.getCase(60, 60));
            unPort=new Port(Game.j1);
            unPort.setCaseParent(Game.plateau.getCase(5, 5));
            uneArtillerie=new UMT_Artillerie(Game.j1, Game.plateau.getCase(55, 55),null);
            uneArtillerie.caseParent.occupant=uneArtillerie;
            uneArtillerie.statut="normal";
        }
        if(clickInSideMenu(gc)){
            getClickInGameButton(gc);   
        }  
        
        //this.writeType(realMouseX, realMouseY);
              /*  try {
                    writeArrayListCases();
               } catch (IOException ex) {
                    Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            System.out.println("\n"+state);
            }
        moveMap(gc);
                
    }
    
}
