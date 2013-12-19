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
    int requisNiveau;
    
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
        this.requisNiveau = 1;
        
        this.consommeNourriture = 0;
        this.consommeBois = 0;
        this.consommeFer = 0;
        this.consommeOr = 0;
    }
    
    @Override public String toString()
    {
        String str = "    [DEF]1    [LEV]1\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " LVL:"+this.requisNiveau+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}