package civilization_batiments;

import civilization.Case;
import static civilization_batiments.HotelDeVille.actions;
import static civilization_batiments.HotelDeVille.constructions;
import civilization_joueurs.Joueur;
import civilization_unites.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maison extends Batiment
{
    public static ArrayList<Class<? extends UniteCivileTerrestre>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCT_Ouvrier.class, UCT_Paysan.class)
    );
    
    public Maison(Joueur j,Case c)
    {
        super(j,c,5,4);    
    }

    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Construire Ouvrier", UCT_Ouvrier.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            //constructions.put("Construire Paysan", UCT_Paysan.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Maison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Maison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Constructor> getConstructions() {
        return constructions;
    }

    @Override
    public Map<String, Method> getActions() {
        return actions;
    }
}
