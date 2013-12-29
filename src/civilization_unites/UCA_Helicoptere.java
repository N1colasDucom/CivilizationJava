package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_Helicoptere extends UniteCivileAerien
{
    public UCA_Helicoptere(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 4;
        this.requisBois = 0;
        this.requisFer = 5;
        this.requisNourriture = 0;
        this.tempsConstruction = 8;
        this.defense = 5;
    }
}