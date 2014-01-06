package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_AviondeLigne extends UniteCivileAerien
{    
    public static String nom = "Avion de ligne";
    
    public UCA_AviondeLigne(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCA_AviondeLigne.nom, 5, 0, 6, 0, 10, 6, x, y, 5);
    }
}
