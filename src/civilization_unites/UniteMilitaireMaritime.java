package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaireMaritime extends UniteMilitaire
{
    public UniteMilitaireMaritime(Joueur joueur)
    {
        super(joueur);
    }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        String typeUnite = this.getClass().getSuperclass().getSimpleName();
        switch (typeUnite) {
            case "UniteMilitaireMaritime":
            case "UniteCivileMaritime":
            case "UniteMilitaireTerrestre":
            case "UniteCivileTerrestre":
                return true;
            default:
                return false;
        }
    }
}
