package civilization_unites;

import civilization.Case;
import civilization.game_engine.Game;
import civilization.game_engine.GameButton;
import civilization.game_engine.Play;
import civilization.game_engine.pathfinder.AStar;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import civilization_exceptions.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Unite 
{
    public Joueur joueur;
    
    public String nom, statut;
  
    public Case caseParent;
    public Batiment batimentParent;

    public int pointsDeVie,pointsDeVieRestants, defense, distanceDeMvt;
    public int requisNourriture, requisBois, requisFer, requisOr, tempsConstruction;
    public int consommeNourriture, consommeBois, consommeFer, consommeOr;
        
    public Unite(Joueur _joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int dist,
            Case caseParent, Batiment batimentParent) 
    {              
        this.nom = nom;        

        this.pointsDeVieRestants=this.pointsDeVie;
        
        this.requisNourriture = nourriture;
        this.requisBois = bois;
        this.requisFer = fer;
        this.requisOr = or;
        this.tempsConstruction = tpsConstruction;
        this.defense = defense;
        
        this.consommeNourriture = 0;
        this.consommeBois = 0;
        this.consommeFer = 0;
        this.consommeOr = 0;
        
        this.caseParent = caseParent;
        this.batimentParent = batimentParent;
        
        this.distanceDeMvt = dist;
        this.statut = "construction";
                

        try {
            if (_joueur.disposeDesRessourcesNessairesPourAcheter(this)) {
                this.joueur = _joueur;
                this.joueur.ajouterUnite(this);
            } else {
                throw new RessourcesInsuffisantesException();
            }
        } catch (RessourcesInsuffisantesException e) {
            System.out.println(e.getMessage());
        }
        if (batimentParent!=null) {
         this.finirConstruction(); 
        }
      
    }
    
    /**
     * Retourne vrai si l'unite peut attaquer
     * @param unite
     * @return 
     */
    public boolean peutAttaquer(Unite unite)
    {
        if (this.equals(unite)) {
            return false;
        } else if (unite.joueur.equals(this)) {
            return false;
        }else {
            return true;
        }
    }
    
    /**
     * Change le statut de l'unite
     * @param s 
     */
    public void changerStatut(String s){
        statut=s;
    }
    
    /**
     * Attribue une case parent a une unite (change de case si l'unite a deja un parent)
     * @param c 
     */
    public void setCaseParent(Case c){
        if (this.caseParent!=null) {
            this.caseParent.occupant=null;
        }      
        this.caseParent=c;
        this.caseParent.occupant=this;
        System.out.println(this.getClass().getSimpleName());
    }
    
    /**
     * Attribue un batiment parent a une unite (change de batiment si l'unite a deja un parent)
     * @param b 
     */
    public void setBatimentParent(Batiment b){
        this.batimentParent=null;
        this.caseParent=null;
        this.batimentParent=b;
    }
    
    /**
     * deplace l'unite vers une nouvelle case
     * @param nvCase 
     */
    public void deplacer(Case nvCase){
        setCaseParent(nvCase);
    }
    
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionX(){
        return this.caseParent.X;
       
    }
    
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionY(){
        return this.caseParent.Y;
    }
    
    /**
     * retourne une liste de coordonnees correspondant au cases vers lesquelles l'unite peut se deplacer
     */
    public void setMovableTiles(){
        int xStart,yStart,xFinish,yFinish;
        int x=this.positionX()+1;
        int y=this.positionY()+1;
        int l=this.distanceDeMvt;
        List<String> movableTypes= movableTypes();
        List<int[]> movableTiles = new ArrayList<>();
        int[] tiles=null;
        xStart=(x-l>0)?(x-l):1;
        yStart=(y-l>0)?(y-l):1;
        xFinish=(x+l<Play.tMap.getWidth())?(x+l):100;
        yFinish=(y+l<Play.tMap.getHeight())?(y+l):100;
        for(int i=xStart;i<=xFinish;i++){
            for(int j=yStart;j<=yFinish;j++){
                if((Math.abs(x-i)+Math.abs(y-j))<=l&&(movableTypes.contains(Game.plateau.cases.get(j-1).get(i-1).type()))&&(Game.plateau.cases.get(j-1).get(i-1).occupant==null)){
                    tiles=new int[2];
                    tiles[0]=i;
                   tiles[1]=j;
                    movableTiles.add(tiles);
                    tiles=null;
                }
            }
        }
        AStar paths= new AStar(Play.tMap.getHeight(), Play.tMap.getWidth(), x, y, l, Game.plateau, movableTypes, movableTiles);
        movableTiles=paths.pathfind();
        Play.movableTiles=movableTiles;
        Play.state="Deplacement";
    }
    
    public Case findExitTile(){
        for (int k = 0; k < 10; k++) {                  
          for (int i = 0; i < k*2+3; i++) {
                for (int j = 0; j < k*2+3; j++) {
                    int y = this.batimentParent.positionX() - 1-k + i;
                    int x = this.batimentParent.positionY() - 1-k + j;
                    if((this.movableTypes().contains(Game.plateau.cases.get(x).get(y).type()))&&(Game.plateau.cases.get(x).get(y).occupant==null)){
                        return Game.plateau.cases.get(x).get(y);
                    }
                }
            }
        }
        return null;
    }
    
    public void exitParent(){
        deplacer(findExitTile());
    }
    
    public void predeplacer(){
        System.out.println("WOUHOUUU!");
    }
    
    /**
     * retourne une liste de boutons correspondant aux actions que peut effectuer cette unite
     * @return 
     */
    public List<GameButton> getMenu(){
      List<GameButton> list = new ArrayList<>();
        try {
          try {
              list.add(new GameButton(810, 100, new Image("Graphics/Buttons/Deplacer.png"),"deplacer",Unite.class.getDeclaredMethod("setMovableTiles"),this));
          } catch (NoSuchMethodException |SecurityException ex) {
              Logger.getLogger(Unite.class.getName()).log(Level.SEVERE, null, ex);
          }
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
      return list;
    }
    
    /**
     * retourne la Sprite de l'unite
     * @return 
     */
    public Image getSprite(){
        try {
            return new Image("Graphics/Units/Unites/"+this.getClass().getSimpleName()+"/sprite.png");
        } catch (SlickException ex) {
            System.out.println("Erreur image:"+this.getClass().getSimpleName());
        }
        return null;
    }
    
   public List<String> movableTypes(){
       List<String> types=new ArrayList<>();
       return types;
   }
   
   public void finirConstruction(){
       this.changerStatut("normal");
       this.exitParent();
   }
    
    /**
     * toString()
     * @return 
     */
    @Override public String toString()
    {
        String str = "";
        str += "    [OWN] "+this.joueur.pseudo+"\n";
        str += "    [DEF] "+this.defense+"\n";
        str += "    [REQ] BOIS:"+this.requisBois+" NOUR:"+this.requisNourriture+" FER:"+this.requisFer+" OR:"+this.requisOr+ " TPS:"+this.tempsConstruction+ "\n";
        str += "    [CNS] BOIS:"+this.consommeBois+" NOUR:"+this.consommeNourriture+" FER:"+this.consommeFer+" OR:"+this.consommeOr+"\n";
        
        return str;
    }
}