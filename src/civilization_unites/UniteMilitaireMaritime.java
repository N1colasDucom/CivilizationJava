package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteMilitaireMaritime extends UniteMilitaire
{
    public UniteMilitaireMaritime(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int attDist, int attPts, int attZones,
            int coordX, int coordY,
            int dist)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, attDist, attPts, attZones, coordX, coordY, dist);
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
