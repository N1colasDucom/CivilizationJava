package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_Helicoptere extends UniteCivileAerien
{
    public static String nom = "Hélicoptère";
    
    public UCA_Helicoptere(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCA_Helicoptere.nom, 4, 0, 5, 0, 8, 5, x, y, 10);
    }
}