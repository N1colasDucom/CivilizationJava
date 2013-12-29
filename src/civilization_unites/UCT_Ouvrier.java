package civilization_unites;

import civilization_joueurs.Joueur;

public class UCT_Ouvrier extends UniteCivileTerrestre
{
    public UCT_Ouvrier(Joueur _joueur)
    {
        super(_joueur, 1, 0, 0, 2, 2, 2);
    }
}