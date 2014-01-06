package civilization_batiments;

import civilization_unites.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Maison extends Batiment
{
    public static ArrayList<Class<? extends UniteCivileTerrestre>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCT_Ouvrier.class, UCT_Paysan.class)
    );
    
    public Maison()
    {
        this.tempsConstruction = 5;
        this.pointsDeVie = 4;
    }
}
