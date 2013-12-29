package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Soldat extends UniteMilitaireTerrestre
{
    public UMT_Soldat(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 4;
        this.requisBois = 0;
        this.requisFer = 3;
        this.requisNourriture = 4;
        this.tempsConstruction = 4;
        this.defense = 6;
        
        this.attaqueDistance = 3;
        this.attaquePoints = 1;
        this.attaqueZones = 1;
    }
}
