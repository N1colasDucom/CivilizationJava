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
    public Aeroport(Joueur j)
    {
        this.joueur=j;
        this.joueur.ajouterBatiment(this);
        this.tempsConstruction = 15;
        this.pointsDeVie = 7;
    }
    
    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Construire Avion de Ligne", UCA_AviondeLigne.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Constuire Hélicoptère Civil", UCA_Helicoptere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Constuire Bombardier", UMA_Bombardier.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Constuire Chasseur", UMA_Chasseur.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Hélicoptère de Combat", UMA_Helicoptere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
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
