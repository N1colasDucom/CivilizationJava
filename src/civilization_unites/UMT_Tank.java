package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMT_Tank extends UniteMilitaireTerrestre
{
    public UMT_Tank(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Tank", 9, 0, 12, 0, 10, 12, 6, 3, 3, 10, caseParent, batimentParent, 24);
    }
}
