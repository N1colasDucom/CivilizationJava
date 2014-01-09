package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Soldat extends UniteMilitaireTerrestre
{
    public UMT_Soldat(Joueur _joueur)
    {
        super(_joueur, "Soldat", 4, 0, 3, 4, 4, 6, 3, 1, 1, 10);
    }
}
