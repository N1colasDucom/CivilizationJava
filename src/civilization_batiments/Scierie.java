package civilization_batiments;

import static civilization_batiments.Maison.actions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scierie extends Batiment
{
    public Scierie() 
    {
        this.tempsConstruction=4;
        this.pointsDeVie=4;
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Scierie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<String, Constructor> getConstructions() {
        return null;
    }

    @Override
    public Map<String, Method> getActions() {
        return actions;
    }
}