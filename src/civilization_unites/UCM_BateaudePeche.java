package civilization_unites;


import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCM_BateaudePeche extends UniteCivileMaritime
{
    public static String nom = "Bateau de Pêche";
      
    public UCM_BateaudePeche(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bâteau de pêche", 3, 4, 2, 0, 5, 4, 10, caseParent, batimentParent, 10);
    }
}
