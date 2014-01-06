package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_PorteAvions extends UniteMilitaireMaritime
{
    public UMM_PorteAvions(Joueur _joueur, int x, int y)
    {
        super(_joueur, "Porte-avions", 9, 0, 12, 0, 14, 18, 12, 6, 1, x, y, 10);
    }
}
