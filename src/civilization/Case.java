/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization;

import civilization_unites.Unite;

/**
 *
 * @author Nicolas
 */
public class Case {
    public Object occupant;
    public int typeCase;
    public int X;
    public int Y;
    
    public Case(int t,int x,int y){
        typeCase=t;
        X=x;
        Y=y;
    }
    
    public String type(){
        switch(this.typeCase){
            case 1:
                return "Eau";
            case 2:
                return "Sable";
            case 3:
                return "Terre";
            case 4:
                return "Foret";
            case 5:
                return "Montagne";
            default:
            System.out.println("Erreur type case");
            break;                  
        }
        return null;          
    }
    
    @Override
    public String toString(){
        return "Case["+this.X+"]["+this.Y+"]("+this.type()+")->"+(Unite)this.occupant;
        
    }
}
