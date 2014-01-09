package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_Helicoptere extends UniteCivileAerien
{
    public static String nom = "Hélicoptère";
    
    public UCA_Helicoptere(Joueur _joueur)
    {
        super(_joueur, UCA_Helicoptere.nom, 4, 0, 5, 0, 8, 5, 10);
    }
}