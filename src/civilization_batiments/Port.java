package civilization_batiments;

import civilization.Case;
import static civilization_batiments.HotelDeVille.actions;
import static civilization_batiments.HotelDeVille.constructions;
import civilization_joueurs.Joueur;
import civilization_unites.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Port extends Batiment
{   
    public Port(Joueur j)
    {
        this.joueur=j;
        this.joueur.ajouterBatiment(this);
        this.tempsConstruction=10;
        this.pointsDeVie=5;
    }
    
    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Construire Bateau de croisière", UCM_BateaudeCroisiere.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Bateau de pêche", UCM_BateaudePeche.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Croiseur", UMM_Croiseur.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Destroyer", UMM_Destroyer.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Porte-avions", UMM_PorteAvions.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Construire Sous-marin", UMM_Sousmarin.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Port.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Port.class.getName()).log(Level.SEVERE, null, ex);
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