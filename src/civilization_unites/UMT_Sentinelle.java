package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Sentinelle extends UniteMilitaireTerrestre
{
    public UMT_Sentinelle(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Sentinelle", 3, 0, 1, 4, 3, 9, 2, 1, 1, x, y, 10);
    }
}
