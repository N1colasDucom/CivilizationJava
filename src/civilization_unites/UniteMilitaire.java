package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    public UniteMilitaire(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, 
            int defense, int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie)
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie);
    }
    
    public void attaquer(Case c){
        if(c.occupant!=null){
            if(c.getOccupantType().equals("Batiment")){
                Batiment batimentAttaque=(Batiment)c.occupant;
                
            }
        }
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
