package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class UCT_Paysan extends UniteCivileTerrestre
{
    public static String nom = "Paysan";

    public UCT_Paysan(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Paysan", 1, 0, 0, 1, 1, 2, 1, caseParent, batimentParent, 5);
    }

    @Override
    public Map<String, Method> getActions() 
    {
        return null;
    }

    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return null;
    }
    
    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        return false;
    }
}
