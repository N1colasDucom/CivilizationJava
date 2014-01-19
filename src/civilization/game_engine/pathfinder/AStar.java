package civilization.game_engine.pathfinder;

import civilization.Plateau;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;

public class AStar {
    SimpleMap map;
    List<int[]> movableTiles;
    int length;
    int startX,startY;
    
    public AStar(int h, int w,int sx, int sy,int l, Plateau p, List<String> nonMovableTypes, List<int[]> mT){
      map=new SimpleMap(h, w, p, nonMovableTypes);
      movableTiles=mT;
      length=l;
      startX=sx;
      startY=sy;
    }
    
    public List<int[]> pathfind(){
        List<int[]> toRemove =new ArrayList<>();
        System.out.println(movableTiles);
        System.out.println(movableTiles.size());
        AStarPathFinder pathFinder = new AStarPathFinder(map, length, false);   
        Path path = new Path();
        for(int i=0;i<this.movableTiles.size();i++){
            if(!canMoveToTile(this.movableTiles.get(i)[0]-1, this.movableTiles.get(i)[1]-1,pathFinder,path)){
              toRemove.add(this.movableTiles.get(i));
               System.out.println("Can't move!");
           
            }
        }
        removeTiles(toRemove, movableTiles);
        pathFinder=null;
        return movableTiles;
    }
    public void removeTiles(List<int[]> toRemove,List<int[]> movableTiles){
        for(int i=toRemove.size()-1;i>=0;i--){
        movableTiles.remove(toRemove.get(i));
        }
        
    }
    
    public boolean canMoveToTile(int goalX,int goalY,AStarPathFinder pathFinder,Path path){        
        path = pathFinder.findPath(null, startX-1, startY-1, goalX, goalY);
        if(path!=null){
        System.out.println("{"+goalX+":"+goalY+"}:"+path.getLength());
        return true;
        }
        else{
            return false;
        }

        
    }
    
}