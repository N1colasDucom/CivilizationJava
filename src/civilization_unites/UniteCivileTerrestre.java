package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteCivileTerrestre extends UniteCivile
{
    boolean peutMarcher = true;
    
    public UniteCivileTerrestre(Joueur joueur)
    {
        super(joueur);
    }
}