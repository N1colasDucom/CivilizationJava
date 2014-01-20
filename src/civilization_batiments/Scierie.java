package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.Unite;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scierie extends Batiment
{
    public Scierie(Joueur j,Case c)
    {
        super(j, c, 4, 4, 6, 2, 3, 0, 2, 0, 4, 0, 0);      
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Batiment.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Batiment.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Scierie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return null;
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
            case "UCT_Ouvrier" :
            case "UCT_Paysan" :
                this.unitesHebergees.add(unite);
                unite.setBatimentParent(this);
                unite.changerStatut("hebergee");
                return true;
            default :
                return false;
        }
    }
    
    @Override
    public boolean peutHebergerUnite(Unite unite) 
    {
        switch (unite.getClass().getSimpleName()) {
            case "UCT_Ouvrier" :
            case "UCT_Paysan" :
                return true;
            default :
                return false;
        }
    }
}