package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Tank extends UniteMilitaireTerrestre
{
    public UMT_Tank(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Tank", 9, 0, 12, 0, 10, 12, 6, 3, 3, x, y, 10);
    }
}
