/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization;

import civilization.game_engine.Game;
import java.util.ArrayList;
import java.util.List;


public class Plateau {
    public List<List<Case>> cases;
   
    
    public Plateau(){
        this.cases = new ArrayList<>();     
    }
    
    public Case getCase(int x,int y){
        return this.cases.get(y-1).get(x-1);
        
    }
}
