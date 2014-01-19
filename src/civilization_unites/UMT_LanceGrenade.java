package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UMT_LanceGrenade extends UniteMilitaireTerrestre
{
    public UMT_LanceGrenade(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Lance-grenade", 5, 1, 5, 5, 6, 10, 4, 2, 2, 10, caseParent, batimentParent, 13);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UMT_LanceGrenade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }
    
    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return null;
    }
}
