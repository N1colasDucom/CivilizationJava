package civilization;

import java.util.ArrayList;
import java.util.List;

public class Plateau 
{
    public List<List<Case>> cases;
   
    public Plateau()
    {
        this.cases = new ArrayList<>();     
    }
    
    public Case getCase(int x,int y)
    {
        return this.cases.get(y-1).get(x-1);
    }
}