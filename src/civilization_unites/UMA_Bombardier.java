package civilization_unites;

import civilization_joueurs.Joueur;

public class UMA_Bombardier extends UniteMilitaireAerien
{
    public UMA_Bombardier(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 6;
        this.requisBois = 0;
        this.requisFer = 8;
        this.requisNourriture = 0;
        this.tempsConstruction = 10;
        this.defense = 12;
        
        this.attaqueDistance = 10;
        this.attaquePoints = 10;
        this.attaqueZones = 2;
    }
}