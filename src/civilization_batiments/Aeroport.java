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

public class Aeroport extends Batiment
{   
    public Aeroport(Joueur j, Case c)
    {
        super(j, c, 15, 7, 10, 4, 5, 0, 5, 0, 0, 0, 0);
    }
    
    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Avion de Ligne", UCA_AviondeLigne.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Hélicoptère Civil", UCA_Helicoptere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Bombardier", UMA_Bombardier.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Chasseur", UMA_Chasseur.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Hélicoptère de Combat", UMA_Helicoptere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
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
            case "UCA_AviondeLigne" :
            case "UCA_Helicoptere" :
            case "UMA_Bombardier" :
            case "UMA_Chasseur" :
            case "UMA_Helicoptere" :
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
