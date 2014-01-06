package civilization_batiments;

import civilization_unites.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Port extends Batiment
{
    public static ArrayList<Class<? extends Unite>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCM_BateaudeCroisiere.class, UCM_BateaudePeche.class, UMM_Croiseur.class, UMM_Destroyer.class, UMM_PorteAvions.class, UMM_Sousmarin.class)
    );
    
    public Port()
    {
        this.tempsConstruction=10;
        this.pointsDeVie=5;
    }
}