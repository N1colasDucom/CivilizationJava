package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_Sousmarin extends UniteMilitaireMaritime
{
    public UMM_Sousmarin(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Sous-marin", 10, 0, 12, 0, 15, 20, 14, 8, 2, x, y, 10);
    }
}
