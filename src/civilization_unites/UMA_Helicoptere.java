package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.HashMap;
import java.util.Map;

public class UMA_Helicoptere extends UniteMilitaireAerien
{    
    public UMA_Helicoptere(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Hélicoptère de combat", 5, 0, 6, 0, 8, 8, 7, 7, 2, 10, caseParent, batimentParent);
    }
}