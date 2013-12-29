package civilization_unites;

import civilization_joueurs.Joueur;

public class UMA_Helicoptere extends UniteMilitaireAerien
{
    public UMA_Helicoptere(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 5;
        this.requisBois = 0;
        this.requisFer = 6;
        this.requisNourriture = 0;
        this.tempsConstruction = 8;
        this.defense = 8;
        
        this.attaqueDistance = 7;
        this.attaquePoints = 7;
        this.attaqueZones = 2;
    }
}