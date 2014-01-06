package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Artillerie extends UniteMilitaireTerrestre
{
    public  UMT_Artillerie(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Artillerie", 7, 2, 10, 0, 8, 8, 5, 3, 3, x, y, 10);
    }
}
