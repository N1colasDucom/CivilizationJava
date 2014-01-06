package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_Croiseur extends UniteMilitaireMaritime
{
    public UMM_Croiseur(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Croiseur", 8, 0, 10, 0, 11, 12, 10, 4, 1, x, y, 10);
    }
}