package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMA_Bombardier extends UniteMilitaireAerien
{    
    public UMA_Bombardier(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bombardier", 6, 0, 8, 0, 10, 12, 10, 10, 2, 10, caseParent, batimentParent);
    }
}