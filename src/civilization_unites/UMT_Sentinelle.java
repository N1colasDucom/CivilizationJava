package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Sentinelle extends UniteMilitaireTerrestre
{
    public UMT_Sentinelle(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 3;
        this.requisBois = 0;
        this.requisFer = 1;
        this.requisNourriture = 4;
        this.tempsConstruction = 3;
        this.defense = 9;
        
        this.attaqueDistance = 2;
        this.attaquePoints = 1;
        this.attaqueZones = 1;
    }
}
