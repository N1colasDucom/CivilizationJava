package civilization_unites;

public class UCM_BateaudePeche extends UniteCivileMaritime
{
    public UCM_BateaudePeche()
    {
        this.requisBois = 2;
        this.requisFer = 2;
        this.requisOr = 3;
    }
    
    @Override public String toString()
    {
        return "Ceci est un Bateau de Peche";
    }
}
