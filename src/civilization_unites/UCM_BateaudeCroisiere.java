package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import static civilization_unites.UCA_Helicoptere.actions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UCM_BateaudeCroisiere extends UniteCivileMaritime
{
    public static String nom = "Bateau de Croisière";
 
    public UCM_BateaudeCroisiere(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bâteau de croisière", 4, 4, 2, 0, 6, 5, 10, caseParent, batimentParent, 12);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UCM_BateaudeCroisiere.class.getName()).log(Level.SEVERE, null, ex);
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
