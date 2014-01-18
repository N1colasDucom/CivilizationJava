package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMM_Sousmarin extends UniteMilitaireMaritime
{
    public UMM_Sousmarin(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Sous-marin", 10, 0, 12, 0, 15, 20, 14, 8, 2, 10, caseParent, batimentParent, 30);
    }
}
