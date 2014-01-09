package civilization_batiments;

import civilization_unites.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Aeroport extends Batiment
{
    public static final ArrayList<Class<? extends Unite>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCA_AviondeLigne.class, UCA_Helicoptere.class, UMA_Bombardier.class, UMA_Chasseur.class, UMA_Helicoptere.class)
    );
    
    public Aeroport()
    {
        this.tempsConstruction = 15;
        this.pointsDeVie = 7;
    }
    
    public ArrayList<Class> getUnitesDisponiblesPourConstruction()
    {
        return new ArrayList<Class>(
            Arrays.asList(UCA_AviondeLigne.class, UCA_Helicoptere.class, UMA_Bombardier.class, UMA_Chasseur.class, UMA_Helicoptere.class)
        );
    }
}
