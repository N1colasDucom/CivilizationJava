package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Port extends Batiment
{   
    public Port(Joueur j,Case c)
    {
        super(j, c, 10, 5, 8, 4, 4, 0, 4, 0, 0, 0, 1);     
    }
    
    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Bateau de croisière", UCM_BateaudeCroisiere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Bateau de pêche", UCM_BateaudePeche.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Croiseur", UMM_Croiseur.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Destroyer", UMM_Destroyer.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Porte-avions", UMM_PorteAvions.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Sous-marin", UMM_Sousmarin.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Port.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Port.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return constructions;
    }

    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }

    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        switch (unite.getClass().getSimpleName()) {
            case "UCM_BateaudeCroisiere" :
            case "UCM_BateaudePeche" :
            case "UMM_Croiseur" :
            case "UMM_Destroyer" :
            case "UMM_PorteAvions" :
            case "UMM_Sousmarin" :
                this.unitesHebergees.add(unite);
                unite.caseParent = null;
                unite.batimentParent = this;
                unite.statut = "hebergee";
                return true;
            default :
                return false;
        }
    }
}