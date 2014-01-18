package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMA_Chasseur extends UniteMilitaireAerien
{    
    public UMA_Chasseur(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Chasseur", 8, 0, 9, 0, 11, 10, 9, 12, 1, 10, caseParent, batimentParent);
    }
}