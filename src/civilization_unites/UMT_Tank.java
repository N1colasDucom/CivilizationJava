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

public class UMT_Tank extends UniteMilitaireTerrestre
{
    public UMT_Tank(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Tank", 9, 0, 12, 0, 10, 12, 6, 3, 3, 10, caseParent, batimentParent, 24);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Déplacer", Unite.class.getDeclaredMethod("setMovableTiles"));
            actions.put("Attaquer", UniteMilitaire.class.getDeclaredMethod("preAttaque"));
            actions.put("En garnison", Unite.class.getDeclaredMethod("preHeberger"));
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UMT_Tank.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        return false;
    }
}
