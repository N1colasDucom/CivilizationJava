package civilization_unites;

import civilization_joueurs.Joueur;

public class UCM_BateaudePeche extends UniteCivileMaritime
{
    public static String nom = "Bateau de Pêche";
    
    public UCM_BateaudePeche(Joueur _joueur, int x, int y)
    {
        super(_joueur, UCM_BateaudePeche.nom, 3, 4, 2, 0, 5, 4, 10);
    }
}
