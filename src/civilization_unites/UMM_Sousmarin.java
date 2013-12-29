package civilization_unites;
import civilization_joueurs.Joueur;

public class UMM_Sousmarin extends UniteMilitaireMaritime
{
    public UMM_Sousmarin(Joueur _joueur)
    {
        super(_joueur);
        
        this.requisOr = 10;
        this.requisBois = 0;
        this.requisFer = 12;
        this.requisNourriture = 0;
        this.tempsConstruction = 15;
        this.defense = 20;
        
        this.attaqueDistance = 14;
        this.attaquePoints = 8;
        this.attaqueZones = 2;
    }
}
