package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteCivileAerien extends UniteCivile
{
    boolean peutVoler = true;
    boolean peutMarcher = true;
    
    public UniteCivileAerien(Joueur joueur)
    {
        super(joueur);
    }
}
