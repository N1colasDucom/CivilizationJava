package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMT_Artillerie extends UniteMilitaireTerrestre
{
    public  UMT_Artillerie(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Artillerie", 7, 2, 10, 0, 8, 8, 5, 3, 3, 10, caseParent, batimentParent);
    }
}
