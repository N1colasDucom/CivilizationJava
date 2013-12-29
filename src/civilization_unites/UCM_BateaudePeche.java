package civilization_unites;

import civilization_joueurs.Joueur;

public class UCM_BateaudePeche extends UniteCivileMaritime
{
    public UCM_BateaudePeche(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 3;
        this.requisBois = 4;
        this.requisFer = 2;
        this.requisNourriture = 0;
        this.tempsConstruction = 5;
        this.defense = 4;
    }
}
