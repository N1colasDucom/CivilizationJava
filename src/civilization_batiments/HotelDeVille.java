package civilization_batiments;

import civilization_unites.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelDeVille extends Batiment 
{    
    public static ArrayList<Class<? extends UniteCivileTerrestre>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCT_Ouvrier.class, UCT_Paysan.class)
    );
    
    public HotelDeVille() 
    {
        this.tempsConstruction = 0;
        this.pointsDeVie = 50;
    }
}