package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Tank extends UniteMilitaireTerrestre
{
    public UMT_Tank(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 9;
        this.requisBois = 0;
        this.requisFer = 12;
        this.requisNourriture = 0;
        this.tempsConstruction = 10;
        this.defense = 12;
        
        this.attaqueDistance = 6;
        this.attaquePoints = 3;
        this.attaqueZones = 3;
    }
}
