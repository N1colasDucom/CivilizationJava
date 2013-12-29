package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaireTerrestre extends UniteMilitaire
{
    public UniteMilitaireTerrestre(Joueur joueur)
    {
        super(joueur);
    }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        String typeUnite = this.getClass().getSuperclass().getSimpleName();
        switch (typeUnite) {
            case "UniteMilitaireTerreste":
            case "UniteCivileTerreste":
                return true;
            default:
                return false;
        }
    }

}
