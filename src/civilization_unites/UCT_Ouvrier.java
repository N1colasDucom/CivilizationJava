package civilization_unites;

public class UCT_Ouvrier extends UniteCivileTerrestre
{
    public UCT_Ouvrier()
    {
        this.tempsConstruction = 2;
        this.pointsDeVie = 10;
        this.defense = 2;
        this.niveau = 1;
        
        this.requisBois = 1;
        this.requisFer = 1;
        this.requisOr = 1;   
        
        this.peutConstruire = true;
    }
}
