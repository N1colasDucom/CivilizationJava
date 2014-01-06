package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_LanceGrenade extends UniteMilitaireTerrestre
{
    public UMT_LanceGrenade(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Lance-grenade", 5, 1, 5, 5, 6, 10, 4, 2, 2, x, y, 10);
    }
}
