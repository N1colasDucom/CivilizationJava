package civilization_unites;

public class Ouvrier extends Unite
{
    public Ouvrier()
    {
        this.tempsConstruction = 2;
        this.pointsDeVie = 10;
        this.defense = 2;
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
