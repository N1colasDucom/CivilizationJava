package civilization_unites;

import civilization_joueurs.Joueur;

public class UMA_Chasseur extends UniteMilitaireAerien
{
    public UMA_Chasseur(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 8;
        this.requisBois = 0;
        this.requisFer = 9;
        this.requisNourriture = 0;
        this.tempsConstruction = 11;
        this.defense = 10;
        
        this.attaqueDistance = 9;
        this.attaquePoints = 12;
        this.attaqueZones = 1;
    }
}