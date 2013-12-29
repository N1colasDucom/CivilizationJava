package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaireAerien extends UniteMilitaire
{
    public UniteMilitaireAerien(Joueur joueur)
    {
        super(joueur);
    }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        String typeUnite = this.getClass().getSuperclass().getSimpleName();
        switch (typeUnite) {
            case "UniteMilitaireAerien":
            case "UniteMilitaireMaritime":
            case "UniteMilitaireTerrestre":
            case "UniteCivileAerien":
            case "UniteCivileTerrestre":
            case "UniteCivileMaritime":
                return true;
            default:
                return false;
        }
    }
}
