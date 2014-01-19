package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.UMT_Artillerie;
import civilization_unites.UMT_BombeNucleaire;
import civilization_unites.UMT_LanceGrenade;
import civilization_unites.UMT_Sentinelle;
import civilization_unites.UMT_Soldat;
import civilization_unites.UMT_Tank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caserne extends Batiment
{
   public Caserne(Joueur j,Case c)
   {
       super(j, c, 15, 10, 6, 4, 6, 1, 3, 0, 0, 0, 0);    
   }
   
   public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
   static {
       try {
            constructions.put("Artillerie", UMT_Artillerie.class.getConstructor(Joueur.class, Case.class, Batiment.class));
           // constructions.put("Constuire Bombe nucléaire", UMT_BombeNucleaire.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Lance-grenade", UMT_LanceGrenade.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Sentinelle", UMT_Sentinelle.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Soldat", UMT_Soldat.class.getConstructor(Joueur.class, Case.class, Batiment.class));
            constructions.put("Tank", UMT_Tank.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Caserne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer bâtiment", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire bâtiment", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Caserne.class.getName()).log(Level.SEVERE, null, ex);
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