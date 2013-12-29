package civilization_unites;

import civilization_joueurs.Joueur;

public class UMM_Croiseur extends UniteMilitaireMaritime
{
    public UMM_Croiseur(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 8;
        this.requisBois = 0;
        this.requisFer = 10;
        this.requisNourriture = 0;
        this.tempsConstruction = 11;
        this.defense = 12;
        
        this.attaqueDistance = 10;
        this.attaquePoints = 4;
        this.attaqueZones = 1;
    }
}