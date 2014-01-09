package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_Destroyer extends UniteMilitaireMaritime
{
    public UMM_Destroyer(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Destroyer", 6, 0, 8, 0, 10, 14, 8, 3, 1, 10);
    }
}
