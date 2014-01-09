package civilization_unites;

import civilization_joueurs.Joueur;

public class UCT_Paysan extends UniteCivileTerrestre
{
    public static String nom = "Paysan";
    
    public UCT_Paysan(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCT_Paysan.nom, 1, 0, 0, 1, 1, 2, 10);
    }
}
