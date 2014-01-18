package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scierie extends Batiment
{
    public Scierie(Joueur j,Case c)
    {
        super(j, c, 4, 4, 6, 2, 3, 0, 2);      
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