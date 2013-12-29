package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_Destroyer extends UniteMilitaireMaritime
{
    public UMM_Destroyer(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 6;
        this.requisBois = 0;
        this.requisFer = 8;
        this.requisNourriture = 0;
        this.tempsConstruction = 10;
        this.defense = 14;
        
        this.attaqueDistance = 8;
        this.attaquePoints = 3;
        this.attaqueZones = 1;
    }
}
