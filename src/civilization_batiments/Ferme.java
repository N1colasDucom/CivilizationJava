package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.UCT_Paysan;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ferme extends Batiment
{    
    public Ferme(Joueur j,Case c)
    {
        super(j, c, 2, 2, 3, 3, 1, 2, 2);
    }

    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Construire Paysan", UCT_Paysan.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Ferme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Ferme.class.getName()).log(Level.SEVERE, null, ex);
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