package civilization_unites;

import civilization_joueurs.Joueur;

public class UCT_Ouvrier extends UniteCivileTerrestre
{
    public static String nom = "Ouvrier";
    
    public UCT_Ouvrier(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCT_Ouvrier.nom, 1, 0, 0, 2, 2, 2, x, y, 10);
    }
}