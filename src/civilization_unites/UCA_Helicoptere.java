package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCA_Helicoptere extends UniteCivileAerien
{    
    public UCA_Helicoptere(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Hélicoptère", 4, 0, 5, 0, 8, 5, 10, caseParent, batimentParent, 13);
    }
}