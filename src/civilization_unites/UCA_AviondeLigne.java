package civilization_unites;

import civilization_joueurs.Joueur;
import java.lang.reflect.Method;

public class UCA_AviondeLigne extends UniteCivileAerien
{    
    public static String nom = "Avion de ligne";
    
    public UCA_AviondeLigne(Joueur _joueur)
    {
        super(_joueur, UCA_AviondeLigne.nom, 5, 0, 6, 0, 10, 6, 5);
    }
    
    public void test()
    {
        for (Method m : this.getClass().getDeclaredMethods()) {
            System.out.println(m.getName());
        }
    }
    
    public void rejoindreAeroport()
    {
        System.out.println("TODO");
    }
}
