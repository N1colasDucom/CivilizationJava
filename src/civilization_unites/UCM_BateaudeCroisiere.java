package civilization_unites;

import civilization_joueurs.Joueur;

public class UCM_BateaudeCroisiere extends UniteCivileMaritime
{
    public UCM_BateaudeCroisiere(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 4;
        this.requisBois = 4;
        this.requisFer = 2;
        this.requisNourriture = 0;
        this.tempsConstruction = 6;
        this.defense = 5;
    }
}
