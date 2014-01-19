package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UCA_AviondeLigne extends UniteCivileAerien
{        
    public UCA_AviondeLigne(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Avion de ligne", 5, 0, 6, 0, 10, 6, 5, caseParent, batimentParent, 15);
    }
  
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UCA_AviondeLigne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }
}
