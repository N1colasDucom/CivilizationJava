package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCM_BateaudeCroisiere extends UniteCivileMaritime
<<<<<<< HEAD
{
    public static String nom = "Bateau de Croisière";
    
    public UCM_BateaudeCroisiere(Joueur _joueur)
=======
{    
    public UCM_BateaudeCroisiere(Joueur _joueur, Case caseParent, Batiment batimentParent)
>>>>>>> 13b6b0003f1125a10090daae83537f690ff68754
    {
        super(_joueur, "Bâteau de croisière", 4, 4, 2, 0, 6, 5, 10, caseParent, batimentParent);
    }
}
