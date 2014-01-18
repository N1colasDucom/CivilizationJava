package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMT_LanceGrenade extends UniteMilitaireTerrestre
{
    public UMT_LanceGrenade(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Lance-grenade", 5, 1, 5, 5, 6, 10, 4, 2, 2, 10, caseParent, batimentParent, 13);
    }
}
