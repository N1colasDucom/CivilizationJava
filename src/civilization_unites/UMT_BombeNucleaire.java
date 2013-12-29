package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_BombeNucleaire extends UniteMilitaireTerrestre
{
    public UMT_BombeNucleaire(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 40;
        this.requisBois = 0;
        this.requisFer = 25;
        this.requisNourriture = 0;
        this.tempsConstruction = 20;
        this.defense = 13;
        
        this.attaqueDistance = 40;
        this.attaquePoints = 10;
        this.attaqueZones = 10;
    }
}
