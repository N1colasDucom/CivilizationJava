package civilization.game_engine;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Engine extends BasicGame
{
        private TiledMap tMap;
        int tMapX=0,tMapY=0;
        static int WSizeX=30*36,WSizeY=20*36;
        int realMouseX=0,realMouseY=0;
        String state = "menu";

        
	public Engine(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
      // civilization.game_engine.mapgenerator.Noise.GenerateMap();
        tMap = new TiledMap("Graphics/Tileset/map.tmx");
        }

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
                   gc.setVSync(true); 
                   if (gc.getInput().isMousePressed(0)) {
                       realMouseX=(gc.getInput().getMouseX()+tMapX*tMap.getTileWidth())/tMap.getTileWidth();
                       realMouseY=(gc.getInput().getMouseY()+tMapY*tMap.getTileHeight())/tMap.getTileHeight();
                       System.out.println("Mouse  :"+realMouseX+" "+realMouseY);
                       

            }
                   
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

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
            
                tMap.render(0,0, tMapX, tMapY,WSizeX,WSizeY);	
           
                
                
                
               
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Engine("Slick"));
			appgc.setDisplayMode(WSizeX, WSizeY, false);
                        appgc.setTargetFrameRate(100);
                        appgc.start();
                }
		catch (SlickException ex)
		{
			Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}