package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMT_Sentinelle extends UniteMilitaireTerrestre
{
    public UMT_Sentinelle(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Sentinelle", 3, 0, 1, 4, 3, 9, 2, 1, 1, 10, caseParent, batimentParent);
    }
}
