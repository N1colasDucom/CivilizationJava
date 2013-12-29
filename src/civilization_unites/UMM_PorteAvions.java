package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_PorteAvions extends UniteMilitaireMaritime
{
    public UMM_PorteAvions(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 9;
        this.requisBois = 0;
        this.requisFer = 12;
        this.requisNourriture = 0;
        this.tempsConstruction = 14;
        this.defense = 18;
        
        this.attaqueDistance = 12;
        this.attaquePoints = 6;
        this.attaqueZones = 1;
    }
}
