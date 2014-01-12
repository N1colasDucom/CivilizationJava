package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMM_Croiseur extends UniteMilitaireMaritime
{
    public UMM_Croiseur(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Croiseur", 8, 0, 10, 0, 11, 12, 10, 4, 1, 10, caseParent, batimentParent);
    }
}