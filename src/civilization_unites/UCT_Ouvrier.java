package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCT_Ouvrier extends UniteCivileTerrestre
{    
    public UCT_Ouvrier(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Ouvrier", 1, 0, 0, 2, 2, 2, 10, caseParent, batimentParent);
    }
}

