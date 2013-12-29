package civilization_unites;

import civilization_joueurs.Joueur;

public class UCT_Ouvrier extends UniteCivileTerrestre
{
    public UCT_Ouvrier(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 1;
        this.requisBois = 0;
        this.requisFer = 0;
        this.requisNourriture = 2;
        this.tempsConstruction = 2;
        this.defense = 2;
    }
}

