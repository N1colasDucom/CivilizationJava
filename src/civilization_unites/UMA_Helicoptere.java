package civilization_unites;

import civilization_joueurs.Joueur;
import java.util.HashMap;
import java.util.Map;

public class UMA_Helicoptere extends UniteMilitaireAerien
{
    public static String nom = "Hélicoptère de combat";
    
    public UMA_Helicoptere(Joueur _joueur)
    {
        super(_joueur, UMA_Helicoptere.nom, 5, 0, 6, 0, 8, 8, 7, 7, 2, 10);
    }
}