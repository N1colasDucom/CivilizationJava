package civilization_unites;


import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UCM_BateaudePeche extends UniteCivileMaritime
{
    public static String nom = "Bateau de Pêche";
      
    public UCM_BateaudePeche(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bâteau de pêche", 3, 4, 2, 0, 5, 4, 10, caseParent, batimentParent, 10);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UCM_BateaudePeche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }
}
