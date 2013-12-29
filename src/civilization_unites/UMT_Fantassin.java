package civilization_unites;

import civilization_joueurs.Joueur;

public class UMT_Fantassin extends UniteMilitaireTerrestre
{
    public UMT_Fantassin(Joueur j1)
    {
        
        super(j1);
        this.requisNourriture = 3;
        this.requisOr = 1;
        this.tempsConstruction = 2;
        
        this.defense = 5;
        //this.degatsInfliges = 1;
    }
}