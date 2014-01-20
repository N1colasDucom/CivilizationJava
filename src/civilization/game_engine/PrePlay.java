package civilization.game_engine;

import civilization.Case;
import static civilization.game_engine.Game.play;
import civilization_batiments.Batiment;
import civilization_batiments.HotelDeVille;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Nicolas
 */
public class PrePlay extends BasicGameState
{
    GameButton randomMap,randomPlacement, startGame, quitGame;
    Image Background, map;
    List<HotelDeVille> HotelsDeVille = new ArrayList<>();
    StateBasedGame game;
    
    PrePlay(int state) 
    {
        
    }
    
    public boolean minDistance(Case c,Case c2)
    {
        return Math.abs(c.X-c2.X)+Math.abs(c.Y-c2.Y)>=20;
    }
    
    public Case caseAleatoire()
    {      
        int x = (int) (Math.random()*100);
        int y= (int) (Math.random()*100);
        return Game.plateau.getCase(x+1, y+1);    
    }
    
    public void randomPlacement()
    {
        List<String> rules = new ArrayList<>();
        HotelsDeVille.clear();
        rules.add("Sable");
        rules.add("Terre");
        rules.add("Foret");
        for(Joueur j:Game.joueurs){
            for(Batiment b:j.batiments){
                b.caseParent.occupant=null;
                b.caseParent=null;
            }
            
            j.batiments.clear();
            Case c = null;
            do {                
            c=caseAleatoire();
            } while (!(rules.contains(c.type())&&c.occupant==null));
            HotelDeVille h = new HotelDeVille(j, c);
            HotelsDeVille.add(h);
        }
        if(!checkDistances(HotelsDeVille)) randomPlacement();
    }
    
    public void DessinerHotelsDeVilles(Graphics g)
    {
       for(HotelDeVille h:HotelsDeVille){
           //Color c = new Color((float)Math.random(),(float) Math.random(),(float)Math.random());
           g.setColor(Color.yellow);
           g.drawRect(162+(300/100*h.positionX()-1), 335+(300/100*h.positionY()-1), 3, 3);
       }
    }
    
    public boolean checkDistances(List<HotelDeVille> HotelsDeVille)
    {
        for(HotelDeVille h:HotelsDeVille){
            for(HotelDeVille h2:HotelsDeVille){
                if(!h.equals(h2)){
                    if(!minDistance(h.caseParent, h2.caseParent)) return false;
                }
            }
        }
        return true;
    }
    
    public void write(){
        for(Joueur j:Game.joueurs){
            System.out.println(j.toString());
        }
    }
    

    
    @Override
    public int getID() 
    {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game=game;
        randomMap = new GameButton(610, 353, new Image("Graphics/Images/Bouton.png"),"Nouvelle carte",null);
        randomPlacement = new GameButton(610, 428, new Image("Graphics/Images/Bouton.png"),"Placer QGs",null);
        startGame = new GameButton(610, 500, new Image("Graphics/Images/Bouton.png"),"JOUER !",null);
        quitGame = new GameButton(610, 573, new Image("Graphics/Images/Bouton.png"), "Quitter", null);
        Game.plateau= civilization.game_engine.mapgenerator.Noise.GenerateMap();
        randomPlacement();
        map = new Image("Graphics/Tileset/gameMap.png");
        Background = new Image("Graphics/Images/MenuSecondaire.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        map.draw(162, 335, 3);
        Background.draw(0, 0);
        randomMap.draw(g);
        randomPlacement.draw(g);
        startGame.draw(g);
        quitGame.draw(g);
        DessinerHotelsDeVilles(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
       int mouseX=gc.getInput().getMouseX();
       int mouseY=gc.getInput().getMouseY();
            if (gc.getInput().isMousePressed(0)) {
           if(randomMap.clickOnMe(mouseX, mouseY)){
             Game.plateau=civilization.game_engine.mapgenerator.Noise.GenerateMap(); 
             map.destroy();
             map = new Image("Graphics/Tileset/gameMap.png");
             this.randomPlacement();
              
           } else if (randomPlacement.clickOnMe(mouseX, mouseY)) {
               this.randomPlacement();
               write();             
           } else if (startGame.clickOnMe(mouseX, mouseY)) {
              game.addState(new Play(play));
              game.getState(play).init(gc, game);
              game.enterState(2);
           } else if (quitGame.clickOnMe(mouseX, mouseY)) {
               gc.exit();
           }
           
        }
    }
    
}
