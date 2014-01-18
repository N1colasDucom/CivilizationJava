package civilization_unites;


import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCM_BateaudePeche extends UniteCivileMaritime
<<<<<<< HEAD
{
    public static String nom = "Bateau de Pêche";
    
    public UCM_BateaudePeche(Joueur _joueur)
=======
{    
    public UCM_BateaudePeche(Joueur _joueur, Case caseParent, Batiment batimentParent)
>>>>>>> 13b6b0003f1125a10090daae83537f690ff68754
    {
        super(_joueur, "Bâteau de pêche", 3, 4, 2, 0, 5, 4, 10, caseParent, batimentParent);
    }
}
