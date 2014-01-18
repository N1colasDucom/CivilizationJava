package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMM_Destroyer extends UniteMilitaireMaritime
{
    public UMM_Destroyer(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Destroyer", 6, 0, 8, 0, 10, 14, 8, 3, 1, 10, caseParent, batimentParent, 20);
    }
}
