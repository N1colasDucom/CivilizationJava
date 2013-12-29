package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_LanceGrenade extends UniteMilitaireTerrestre
{
    public UMT_LanceGrenade(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 5;
        this.requisBois = 1;
        this.requisFer = 5;
        this.requisNourriture = 5;
        this.tempsConstruction = 6;
        this.defense = 10;
        
        this.attaqueDistance = 4;
        this.attaquePoints = 2;
        this.attaqueZones = 2;
    }
}
