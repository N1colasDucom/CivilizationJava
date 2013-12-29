package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Artillerie extends UniteMilitaireTerrestre
{
    public  UMT_Artillerie(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 7;
        this.requisBois = 2;
        this.requisFer = 10;
        this.requisNourriture = 0;
        this.tempsConstruction = 8;
        this.defense = 8;
        
        this.attaqueDistance = 5;
        this.attaquePoints = 3;
        this.attaqueZones = 3;
    }
}
