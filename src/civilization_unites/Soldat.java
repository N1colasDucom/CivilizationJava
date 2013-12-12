package civilization_unites;

public class Soldat extends Unite
{
    public Soldat()
    {
        this.tempsConstruction = 4;
        this.pointsDeVie = 20;
        this.defense = 10;
        this.niveau = 1;

        this.requiertNourriture = 2;
        this.consommeNourriture = 1;

        this.capaciteDeProduction = 5;

        this.degatsInfliges = 0;
        
        this.peutConstruire = true;
        this.peutChercherNourriture = true;
        this.peutCombattre = false;
    }
}
