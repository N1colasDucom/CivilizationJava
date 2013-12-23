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
        int tMapX=0,tMapY=0,tMapXX=0,tMapYY=0;
        static int WSizeX=1280,WSizeY=720;
        int realMouseX=0,realMouseY=0;
        
	public Engine(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
        tMap = new TiledMap("Graphics/Tileset/example.tmx");
        }

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
                   gc.setVSync(true);
                   if (gc.getInput().isMousePressed(0)) {
                       realMouseX=gc.getInput().getMouseX()-tMapX;
                       realMouseY=gc.getInput().getMouseY()-tMapY;
                       System.out.println("Mouse 1 :"+realMouseX+" "+realMouseY);
                       System.out.println("Cell X: "+(realMouseX-(WSizeX-100*32)/2)/32);
                       System.out.println("Cell Y: "+(realMouseY-(WSizeY-100*32)/2)/32);
                       
            }
                   
        if( gc.getInput().isKeyDown(Input.KEY_RIGHT) )
		{
			tMapX--;
		}
 
		if( gc.getInput().isKeyDown(Input.KEY_LEFT) )
		{
			tMapX++;
		}
		if( gc.getInput().isKeyDown(Input.KEY_UP) )
		{
			tMapY++;
		}
 
		if( gc.getInput().isKeyDown(Input.KEY_DOWN) )
		{
			tMapY--;
		}
        }

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
                tMap.render(tMapX, tMapY, 0, 0, WSizeX, WSizeY);	
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Engine("Simple Slick Game"));
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