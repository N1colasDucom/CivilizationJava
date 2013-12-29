package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_AviondeLigne extends UniteCivileAerien
{
    public UCA_AviondeLigne(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 5;
        this.requisBois = 0;
        this.requisFer = 6;
        this.requisNourriture = 0;
        this.tempsConstruction = 10;
        this.defense = 6;
    }
}
