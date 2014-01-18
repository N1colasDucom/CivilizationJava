package civilization.game_engine;

import civilization.Case;
import civilization.game_engine.mapgenerator.ImageWriter;
import civilization.unTour.UnTour;
import civilization_batiments.*;
import civilization_joueurs.Joueur;
import civilization_unites.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

public class Play extends BasicGameState
{
    Aeroport unAeroport, unAeroport2;
    Caserne uneCaserne;
    UMT_Artillerie uneArtillerie;
    Port unPort;
    UCT_Ouvrier unOuvrier;
    
    public UnTour unTour;
    public static TiledMap tMap=null;
    int tMapX=0,tMapY=0;
    static int WSizeX=1000,WSizeY=800;
    int realMouseX=0,realMouseY=0;
    int[] square;
    public static List<int[]> movableTiles=null;
    public static List<int[]> placeableTiles=null;
    private List<GameButton> actionButtons;
    private GameButton prochainTour;
    public static String state;
    public static Case pastTile;
    Image Background, map;
    
    public Play(int State)
    {
        
    }
    
    public void setMovableTiles(List<int[]> mt)
    {
        movableTiles=mt;
    }
    
    /**
     * Affiche la grille (Separation des cases)
     * @param g 
     */
    public void drawGrid(Graphics g)
    {
        g.setColor(Color.black);
        for(int i=0;i<=25;i++){
            g.drawLine(32*i, 0, 32*i, 640);      
        }
        
        for(int i=0;i<=20;i++){
            g.drawLine(0,32*i, 800, 32*i);
        }    
    }
    
    /**
     * Verifie si le click a bien eu lieu dans une case, si oui retourne le menu de l'occupant si
     * celui-ci appartient au joueur
     * @param gc 
     */
    public void clickInTile(GameContainer gc)
    {
        this.actionButtons.clear();
        if(Game.plateau.getCase(realMouseX, realMouseY).occupant!=null) { 
            if(myEntity()) {
                this.actionButtons=Game.plateau.getCase(realMouseX, realMouseY).getOccupantMenu();
            }     
            state="unite";
        }
    }
    
    /**
     * retourne vrai si l'entite selectionnee appartient au joueur
     * @return 
     */
    public boolean myEntity()
    {
        String classTemp= Game.plateau.getCase(realMouseX, realMouseY).getOccupantType();
        switch (classTemp) {
            case "Batiment":
                if(((Batiment)Game.plateau.getCase(realMouseX, realMouseY).occupant).joueur.equals(UnTour.joueurActif)){
                    return true;
                }
                break;
            case "Unite":
                if(((Unite)Game.plateau.getCase(realMouseX, realMouseY).occupant).joueur.equals(UnTour.joueurActif)){
                    return true;
                }
                break;
        }
        return false;
    }
    
    /**
     * affiche le menu d'unite/Batiment
     * @param g 
     */
    public void drawActionMenu(Graphics g)
    {        
        for(int i=0;i<this.actionButtons.size();i++) {
            this.actionButtons.get(i).draw(g);               
        }
    }
    
    /**
     * affiche les unites du joueur
     * @param g 
     */
    public void drawUnits(Graphics g,Joueur j)
    {
        if(!j.unites.isEmpty()) {
            for(int i=0;i<j.unites.size();i++) {   
                if(!j.unites.get(i).statut.equals("construction")) {
                    if ((((j.unites.get(i).positionX())*32-32*tMapX<25*32)&&(j.unites.get(i).positionY()*32-32*tMapY<20*32))) {
                        j.unites.get(i).getSprite().draw((float)(j.unites.get(i).positionX()*32-32*tMapX),(float)(j.unites.get(i).positionY()*32-32*tMapY),(float)32,(float)32);
                    }
                }
            }
        }
    }
    
    /**
     * Affiche les batiments du joueur
     * @param g 
     */
    public void drawBuildings(Graphics g, Joueur j)
    {
        if(!j.batiments.isEmpty()) {
            for(int i=0;i<j.batiments.size();i++) {   
                if ((((j.batiments.get(i).positionX())*32-32*tMapX<25*32)&&(j.batiments.get(i).positionY()*32-32*tMapY<20*32))) {
                    j.batiments.get(i).getSprite().draw((float)(j.batiments.get(i).positionX()*32-32*tMapX),(float)(j.batiments.get(i).positionY()*32-32*tMapY),(float)32,(float)32);
                }
            }
        }
    }
    
    /**
     * Retourne vrai si le click a eu lieu dans la carte de jeu
     * @param gc
     * @return 
     */
    public boolean clickInMap(GameContainer gc)
    {
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        
        return ((x>0&&x<tMap.getTileWidth()*25)&&(y>0&&y<tMap.getTileHeight()*20))?true:false;
    }
    
    /**
     * Pour chaque bouton du menu d'unite, verifie si le bouton a ete clique, si oui effectue son action
     * @param gc 
     */
    public void getClickInGameButton(GameContainer gc)
    {
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        for(int i=0;i<this.actionButtons.size();i++) {
            if(this.actionButtons.get(i).clickOnMe(x, y)) {
                this.actionButtons.get(i).doAction();
            }
        }
    }
    
    /**
     * Verifie si le clique a eu lieu dans le Menu de droite
     * @param gc
     * @return 
     */
    public boolean clickInSideMenu(GameContainer gc)
    {
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        
        return ((x>tMap.getTileWidth()*25&&x<WSizeX)&&(y>0&&y<tMap.getTileHeight()*20))?true:false;
    }
    
    /**
     * Verifie si le clique a eu lieu en dessous de la carte
     * @param gc
     * @return 
     */
    public boolean clickInBottomPane(GameContainer gc)
    {
        int x=gc.getInput().getMouseX();
        int y=gc.getInput().getMouseY();
        
        return ((x>0&&x<tMap.getTileWidth()*25)&&(y>tMap.getTileHeight()*20&&x<WSizeY))?true:false;
    }
    
    /**
     * Fonction de debug:
     * Retourne le type de la case clique ainsi que quelques info supplementaires
     * @param x
     * @param y 
     */
    public void writeType(int x, int y)
    {
        System.out.println(Game.plateau.cases.size());
        System.out.println(Game.plateau.cases.get(y-1).size());
        System.out.println(Game.plateau.cases.get(y-1).get(x-1).type());
        System.out.println(Game.plateau.cases.get(y-1).get(x-1).typeCase);
    }
    
    /**
     * Fonction de debug:
     * Dans un txt, insere le type de toutes les cases 
     * @throws IOException 
     */
    public void writeArrayListCases() throws IOException
    {
        FileWriter fstream = null;
        try {
            fstream = new FileWriter("test2.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(ImageWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter out = new BufferedWriter(fstream);
        int i=0,j=0;
            
        for(i=1;i<=100;i++) {
            for(j=1;j<=100;j++) {
                out.write(Integer.toString(Game.plateau.cases.get(i-1).get(j-1).typeCase));
            }
            out.write("\n");
        }
        out.close();
    }
    
    /**
     * Quand la map a ete choisi, la selectionne comme map de jeu
     * @throws SlickException 
     */
    public void setMap() throws SlickException
    {
        tMap = new TiledMap("Graphics/Tileset/map.tmx"); 
        map = new Image("Graphics/Tileset/gameMap.png");
    }
    
    /**
     * Affiche les cases sur lesquelles une unite peut se deplacer
     */
    public void printMovableTiles()
    {
        System.out.println("Movable:");
        System.out.println("Empty:"+this.movableTiles.isEmpty());
        System.out.println("Size:"+this.movableTiles.size());
        
        for(int[] tile:movableTiles){
            System.out.println("Tiles");
        }  
    }
    
    /**
     * Verifie si le clique a eu lieu dans une case valide
     * @param tiles
     * @param tile
     * @return 
     */
    public boolean isValidTile(List<int[]> tiles, int[] tile)
    {
        for (int[] tileTemp:tiles){
            System.out.println(tileTemp[0]+":"+tileTemp[1]+"/"+tile[0]+":"+tile[1]);
            if (tileTemp[0]==tile[0]&&tileTemp[1]==tile[1]) {
                return true;
            }
        }  
        
        return false;
    }
    
    /**
     * Affiche les Tiles sur lesquelles une unite peut se deplacer
     * @param g 
     */
    public void drawMovableTiles(Graphics g)
    {
        if (Play.movableTiles!=null) {
            Color Fill = new Color(0.0f, 6.0f, 0.0f, 0.5f);   
            g.setColor(Fill);
            for (int i=0;i<Play.placeableTiles.size();i++){
                if ((((Play.placeableTiles.get(i)[0]-1)*32-32*tMapX<25*32)&&((Play.placeableTiles.get(i)[1]-1)*32-32*tMapY<20*32))) {
                    g.fillRect((float)(Play.placeableTiles.get(i)[0]*32-32*tMapX-31),(float)(Play.placeableTiles.get(i)[1]*32-32*tMapY-31), 31, 31);
                }
            }
        } 
    }
    
    /**
     * Affiche les Tiles sur lesquelles un ouvrier peut construire un batiment
     * @param g 
     */
    public void drawPlaceableTiles(Graphics g)
    {
        Color Fill = new Color(0.0f, 0.0f, 6.0f, 0.5f);   
        g.setColor(Fill);
        for (int i=0;i<Play.movableTiles.size();i++){
            if ((((Play.movableTiles.get(i)[0]-1)*32-32*tMapX<25*32)&&((Play.movableTiles.get(i)[1]-1)*32-32*tMapY<20*32))) {
                g.fillRect((float)(Play.movableTiles.get(i)[0]*32-32*tMapX-31),(float)(Play.movableTiles.get(i)[1]*32-32*tMapY-31), 31, 31);
            }
        } 
    }
    
    /**
     * 
     * @param gc 
     */
    public void stateActions(GameContainer gc)
    {
        if(deplacer(gc)) {
        
        } else if(construire(gc)) {
        
        } else {
            if(movableTiles!=null) {
                movableTiles.clear();
            }
            if(placeableTiles!=null) {
                placeableTiles.clear();
            }
            state="normal";
        }        
    }
    
    public boolean deplacer(GameContainer gc)
    {
        int[] tileTemp= new int[2];
        tileTemp[0]=realMouseX;
        tileTemp[1]=realMouseY;
        if (state.equals("Deplacement")&&isValidTile(movableTiles,tileTemp)) { 
            ((Unite)pastTile.occupant).deplacer(Game.plateau.getCase(realMouseX, realMouseY));
            if(movableTiles!=null) {
                movableTiles.clear();
            }
            return true;
        }
        return false;  
    }
    
    public boolean construire(GameContainer gc)
    {
        int[] tileTemp= new int[2];
        tileTemp[0]=realMouseX;
        tileTemp[1]=realMouseY;
        if(state.equals("Construction")&&isValidTile(placeableTiles,tileTemp)) {
            ((UCT_Ouvrier)pastTile.occupant).construire(Game.plateau.getCase(realMouseX, realMouseY));
            if(placeableTiles!=null){
                placeableTiles.clear();
            }
            return true;
        }
        return false; 
    }
    
    public void updatePastTile(GameContainer gc)
    {
        pastTile=Game.plateau.getCase(realMouseX, realMouseY);
    }
    
    /**
     * Change de tour
     */
    public void newTour()
    {
        unTour = new UnTour();
    }
    
    /**
     * Deplace la map
     * @param gc 
     */
    public void moveMap(GameContainer gc)
    {
        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            if (tMapX+25<tMap.getWidth()) {
                tMapX++;
            }
        } else if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            if (tMapX>0) {
                tMapX--;
            }
        } else if( gc.getInput().isKeyDown(Input.KEY_UP)) {
            if (tMapY>0) {
                tMapY--;
            }
        } else if( gc.getInput().isKeyDown(Input.KEY_DOWN)) {
            if (tMapY+20<tMap.getHeight()) {
                tMapY++;
            }
        }
    }
    
    /**
     * ID de ce GameState
     * @return 
     */
    @Override
    public int getID() 
    {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        Background = new Image("Graphics/Images/Jeu.png");
        actionButtons = new ArrayList<>();  
        movableTiles= new ArrayList<>();
        placeableTiles = new ArrayList<>();
        System.out.println(Game.joueurs.get(0));
        try {
            prochainTour = new GameButton(800, 640, new Image("Graphics/Buttons/Button.png"),"Fin Tour", Play.class.getDeclaredMethod("newTour"), this);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        state="normal";
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        tMap.render(0,0, tMapX, tMapY,25,20);
        map.draw(0,640,0.8f);
        Background.draw(0, 0);
        prochainTour.draw(g);
        drawGrid(g);
        if(square!=null) {
            Color Trans = new Color(1f, 1f, 1f, 0.5f);
            g.setColor(Trans);      
            g.drawRect((float)(square[0]*32-32*tMapX-32+1),(float)(square[1]*32-32*tMapY-32+1), 30, 30);
        }
        /*if(state.equals("Deplacement"))*/ this.drawMovableTiles(g);
        /*if(state.equals("Construction"))*/ this.drawPlaceableTiles(g);
       if (!this.actionButtons.isEmpty()){
           drawActionMenu(g);
       }

       for (Joueur j : Game.joueurs) {
           this.drawUnits(g, j);
           this.drawBuildings(g, j);
       }        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException 
    {
        GameButton gb;
        if (this.tMap==null){
            this.setMap();
        }
        if (gc.getInput().isMousePressed(0)) {
           
        realMouseX=(gc.getInput().getMouseX()+tMapX*tMap.getTileWidth())/tMap.getTileWidth()+1;
        realMouseY=(gc.getInput().getMouseY()+tMapY*tMap.getTileHeight())/tMap.getTileHeight()+1;
        System.out.println("Mouse  :"+gc.getInput().getMouseX()+" "+gc.getInput().getMouseY());
        if(prochainTour.clickOnMe(gc.getInput().getMouseX(), gc.getInput().getMouseY())){prochainTour.doAction();}
        if(clickInMap(gc)){
           
            square=null;
        square=new int[]{realMouseX, realMouseY};
        //this.setMovableTiles(realMouseX, realMouseY, 8);
            System.out.println(Game.plateau.getCase(realMouseX, realMouseY).toString());
            //System.out.println(Game.j1.unites.size());
            this.clickInTile(gc);
            stateActions(gc);
            updatePastTile(gc);
            if(pastTile!=null){
            if(realMouseX!=pastTile.X||realMouseY!=pastTile.Y)  System.out.println("("+realMouseX+":"+realMouseY+")("+pastTile.X+":"+pastTile.Y+")");
            }
            
        }
        if(clickInBottomPane(gc)){
            //unAeroport=new Aeroport(Game.j1,Game.plateau.getCase(50, 50));
            unAeroport2=new Aeroport(Game.joueurs.get(0),Game.plateau.getCase(60, 60));
            unPort=new Port(Game.joueurs.get(0),Game.plateau.getCase(5, 5));
            uneCaserne = new Caserne(Game.joueurs.get(0), Game.plateau.getCase(95, 95));
            uneArtillerie=new UMT_Artillerie(Game.joueurs.get(0), Game.plateau.getCase(55, 55),null);
            uneArtillerie.caseParent.occupant=uneArtillerie;
            uneArtillerie.statut="normal";
            unOuvrier=new UCT_Ouvrier(Game.joueurs.get(0), Game.plateau.getCase(50, 50),null);
            unOuvrier.caseParent.occupant=unOuvrier;
            unOuvrier.statut="normal";
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