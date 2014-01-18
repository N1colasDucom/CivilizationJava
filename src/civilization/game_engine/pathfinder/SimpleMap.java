/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.game_engine.pathfinder;

import civilization.Plateau;
import java.util.List;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author Nicolas
 */
public class SimpleMap implements TileBasedMap{
    int height,width;
    private static int[][] MAP=null;
    
    @Override
    public int getWidthInTiles() {
        return width;
    }

    @Override
    public int getHeightInTiles() {
        return height;
    }

    @Override
    public void pathFinderVisited(int x, int y) {}

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        return MAP[tx][ty]==1;
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {
            return 1.0f;
    }
    
    private void BuildMap(Plateau p, List<String> nonMovableTypes){
        MAP = new int[100][100];
       for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               if(nonMovableTypes.contains(p.getCase(i+1,j+1).type())&&p.getCase(i+1,j+1).occupant==null){
                   MAP[i][j]=0;
                   
               }
               else{
                   MAP[i][j]=1;
               }
           }
       }
        
    }
    
    public SimpleMap(int h, int w, Plateau p, List<String> nonMovableTypes){
        height=h;
        width=w;              
        BuildMap(p, nonMovableTypes);
    }
    
}
