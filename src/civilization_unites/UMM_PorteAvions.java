package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMM_PorteAvions extends UniteMilitaireMaritime
{
    public UMM_PorteAvions(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Porte-avions", 9, 0, 12, 0, 14, 18, 12, 6, 1, 10, caseParent, batimentParent, 25);
    }
}
