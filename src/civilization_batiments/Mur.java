package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.Unite;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mur extends Batiment
{
    public Mur(Joueur j,Case c) 
    {
        super(j, c, 10, 20, 1, 1, 2, 0, 3, 0, 0, 0, 0);        
    }

    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Mur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return null;
    }

    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }

    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        return false;
    }
}