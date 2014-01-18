package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCT_Paysan extends UniteCivileTerrestre
{
    public static String nom = "Paysan";

    public UCT_Paysan(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Paysan", 1, 0, 0, 1, 1, 2, 10, caseParent, batimentParent, 5);
    }
}
