package civilization_unites;

import civilization_joueurs.Joueur;

public class UCT_Paysan extends UniteCivileTerrestre
{
    public UCT_Paysan(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 1;
        this.requisBois = 0;
        this.requisFer = 0;
        this.requisNourriture = 1;
        this.tempsConstruction = 1;
        this.defense = 2;
    }
}
