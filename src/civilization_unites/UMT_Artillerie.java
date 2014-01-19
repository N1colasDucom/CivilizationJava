package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import static civilization_unites.UCA_Helicoptere.actions;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UMT_Artillerie extends UniteMilitaireTerrestre
{
    public  UMT_Artillerie(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Artillerie", 7, 2, 10, 0, 8, 8, 5, 3, 3, 10, caseParent, batimentParent, 20);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UMT_Artillerie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }
}
