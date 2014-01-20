package civilization_unites;

import civilization.Case;
import civilization.game_engine.Game;
import civilization.game_engine.Play;
import civilization.game_engine.pathfinder.AStar;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteMilitaire extends Unite
{
    int attaquePoints;
    int attaqueDistance;
    int attaqueZones;
    
    /**
     * Construit une Unité Militaire (hériant d'Unité).
     * @param joueur Propriétaire de l'unité
     * @param nom Nom de l'unité
     * @param or Quantité d'or requise
     * @param bois Quantité de bois requise
     * @param fer Quantité de fer requise
     * @param nourriture Quantité de nourriture requise
     * @param tpsConstruction Temps de construction requis
     * @param defense Points de défense
     * @param attDist Distance d'attaque
     * @param attPts Points d'attaque
     * @param attZones Zones d'attaque
     * @param dist Distance par tour
     * @param caseParent Case qui contient l'unité
     * @param batimentParent Bâtiment qui contient l'unité
     * @param ptVie Points de vie
     */
    public UniteMilitaire(
            Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, 
            int defense, int attDist, int attPts, int attZones,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie
    ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie, 0, 0, 0, 0);
        this.attaqueDistance=attDist;
        this.attaquePoints=attPts;
        this.attaqueZones=attZones;
    }
    
    public void preAttaque()
    {    
        int xStart, yStart, xFinish, yFinish;
        int x = this.positionX() + 1;
        int y = this.positionY() + 1;
        int l = this.attaqueDistance;
        List<int[]> attackables = new ArrayList<>();
        int[] tiles=null;
        xStart=(x-l>0)?(x-l):1;
        yStart=(y-l>0)?(y-l):1;
        xFinish=(x+l<Play.tMap.getWidth())?(x+l):100;
        yFinish=(y+l<Play.tMap.getHeight())?(y+l):100;
        for(int i=xStart;i<=xFinish;i++){
            for(int j=yStart;j<=yFinish;j++){
                if((Math.abs(x-i)+Math.abs(y-j))<=l){
                   if(preAttackConditions(Game.plateau.getCase(i, j))){
                    tiles=new int[2];
                    tiles[0]=i;
                    tiles[1]=j;
                    attackables.add(tiles);
                       System.out.println("Attackable!");
                    tiles=null;
                   }               
                } else {
                    System.out.println("Not Attackable!");
                }
            }
        }
        Play.attackables=attackables;
        Play.state="Attaque";
    }
    
    public boolean preAttackConditions(Case c){
          if (c.occupant != null) {
              System.out.println("Occupant!:"+c.occupant.getClass().getSimpleName());
            switch (c.getOccupantType()) {
                case "Batiment":
                    Batiment batimentAttaque = (Batiment) c.occupant;
                    if (this.peutAttaquer(batimentAttaque)) {
                        return true;
                    }
                    break;
                    
                case "Unite":
                    Unite uniteAttaquee = (Unite) c.occupant;
                    if (this.peutAttaquer(uniteAttaquee)) {
                        return true;
                    }
                    break;
            }
        }else {
        System.out.println("occupant Null!");
    }
       return false;
    }
        
    
    
    public void attaquer(Case c) 
    { 
        if (c.occupant != null) {
            switch (c.getOccupantType()) {
                case "Batiment":
                    Batiment batimentAttaque = (Batiment) c.occupant;
                    if (this.peutAttaquer(batimentAttaque)) {
                        batimentAttaque.pointsDeVieRestants -= this.attaquePoints;
                        if (batimentAttaque.pointsDeVieRestants <= 0) {
                            batimentAttaque.detruire();
                            System.out.println("ATAAAAAQUE");
                        }
                    }
                    break;
                    
                case "Unite":
                    Unite uniteAttaquee = (Unite) c.occupant;
                    if (this.peutAttaquer(uniteAttaquee)) {
                        uniteAttaquee.pointsDeVieRestants -= this.attaquePoints;
                        if (uniteAttaquee.pointsDeVieRestants <= 0) {
                            uniteAttaquee.detruire();
                            System.out.println("ATAAAAAQUE");
                        }
                    }
                    break;
            } 
        }
    }
    
    /**
     * Toutes les unités militaires peuvent attaquer un bâtiment.
     * @param batiment
     * @return boolean
     */
    @Override 
    public final boolean peutAttaquer(Batiment batiment)
    {
        return true;
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
