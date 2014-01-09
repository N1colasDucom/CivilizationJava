package civilization_unites;

import civilization_joueurs.Joueur;

public class UCM_BateaudeCroisiere extends UniteCivileMaritime
{
    public static String nom = "Bateau de Croisière";
    
    public UCM_BateaudeCroisiere(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCM_BateaudeCroisiere.nom, 4, 4, 2, 0, 6, 5, 10);
    }
}
