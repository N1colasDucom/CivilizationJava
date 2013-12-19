package civilization_unites;

public abstract class Unite 
{
    int tempsConstruction;
    int pointsDeVie;
    int defense;
    int niveau;
    
    int requisNourriture;
    int requisBois;
    int requisFer;
    int requisOr;
    
    int consommeNourriture;
    int consommeBois;
    int consommeFer;
    int consommeOr;

    public Unite() {
        this.defense = 1;
        this.niveau = 1;
        
        this.requisNourriture = 0;
        this.requisBois = 0;
        this.requisFer = 0;
        this.requisOr = 0;
        
        this.consommeNourriture = 0;
        this.consommeBois = 0;
        this.consommeFer = 0;
        this.consommeOr = 0;
    }
}