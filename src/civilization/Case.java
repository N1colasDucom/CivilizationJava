package civilization;

import civilization.game_engine.GameButton;
import civilization_batiments.Batiment;
import civilization_unites.Unite;
import java.util.List;

public class Case 
{
    public Object occupant;
    public int typeCase;
    public int X;
    public int Y;
    
    public Case(int t,int x,int y)
    {
        typeCase = t;
        X = x;
        Y = y;
    }
    
    /**
     * Type de terrain en fonction du code terrain
     * @return 
     */
    public String type()
    {
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
    
    /**
     * retourne une liste de boutons correspondant aux actions que peut effectuer l'occupant
     * @return 
     */
    public List<GameButton> getOccupantMenu()
    {
        String occupantClass = this.getOccupantType(); 
        System.out.println(occupantClass);
        if (occupantClass.equals("Unite")) {
            return ((Unite)occupant).getMenu();
        } else if(occupantClass.equals("Batiment")) {
            return ((Batiment)this.occupant).getMenu();
        }
       
        return null;
    }
   
    /**
     * Retourne Unite ou Batiment en fonction du type de l'occupant
     * @return 
     */
    public String getOccupantType()
    {
        if(this.occupant!=null){
        Class c = occupant.getClass();
        while(c!=null){
            if(c.getSimpleName().equals("Unite")) return c.getSimpleName();
            else if(c.getSimpleName().equals("Batiment")) return c.getSimpleName();
            c=c.getSuperclass();
        }}
        return "Erreur Classe Occupant";        
    }
    
    /**
     * toString()
     * @return 
     */
    @Override
    public String toString()
    {
        return "Case["+this.X+"]["+this.Y+"]("+this.type()+")->";//+((Unite)this.occupant).toString();
    }
}
