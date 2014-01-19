package civilization_unites;

import civilization.Case;
import civilization.game_engine.Game;
import civilization.game_engine.GameButton;
import civilization.game_engine.Play;
import civilization.game_engine.pathfinder.AStar;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import civilization_exceptions.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Unite 
{
    public Joueur joueur;
    
    public String nom, statut;
  
    public Case caseParent;
    public Batiment batimentParent;

    public int pointsDeVie, pointsDeVieRestants, defense, distanceDeMvt, niveau;
    public int requisNourriture, requisBois, requisFer, requisOr, tempsConstruction, prodOr, prodBois, prodFer, prodNourr;
    public int consommeNourriture, consommeBois, consommeFer, consommeOr;
    public boolean actionDuTourRealisee = false;
    
    public ArrayList<Unite> unitesHebergees = new ArrayList<>();
        
    public Unite(Joueur _joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie,
            int prodOr, int prodBois, int prodFer, int prodNourr
    ) {              
        this.nom = nom;           
        this.pointsDeVie=ptVie;
        this.pointsDeVieRestants = ptVie;
        this.niveau = 1;
        
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
        
        this.prodOr = prodOr;
        this.prodBois = prodBois;
        this.prodFer = prodFer;
        this.prodNourr = prodNourr;
        
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
        
        if (batimentParent != null) {
            this.finirConstruction(); 
        }
    }
    
    /**
     * Retourne vrai si l'unite peut attaquer une unité donnée.
     * @param unite
     * @return 
     */
    public abstract boolean peutAttaquer(Unite unite);
    
    /**
     * Retourne vrai si l'unité peut attaquer un bâtiment donné.
     * @param batiment
     * @return 
     */
    public abstract boolean peutAttaquer(Batiment batiment);
    
    /**
     * Constructions disponibles pour une unité.
     * @return 
     */
    public abstract Map<String, Constructor> getConstructions();
    
    /**
     * Actions disponibles pour une unité
     * @return 
     */
    public abstract Map<String, Method> getActions();
    
    /**
     * Lorsqu'une unité peut en "héberger" une autre (ex: un avion de ligne peut transporter un passager)
     * @param unite
     * @return boolean
     */
    public abstract boolean hebergerUnite(Unite unite);
    
    /**
     * Ajoute les ressources produits par un batiment à un joueur.
     * @param joueur 
     */
    public void produireDesRessources(Joueur joueur)
    {
        joueur.ressourcesOr += this.prodOr;
        joueur.ressourcesBois += this.prodBois;
        joueur.ressourcesFer += this.prodFer;
        joueur.ressourcesNourriture += this.prodNourr;
    }
        
    /**
     * Change le statut de l'unite
     * @param s 
     */
    public void changerStatut(String s)
    {
        statut = s;
    }
    
    /**
     * Attribue une case parent a une unite (change de case si l'unite a deja un parent)
     * @param c 
     */
    public void setCaseParent(Case c) 
    {
        if (this.caseParent != null) {
            this.caseParent.occupant = null;
        }      
        this.caseParent = c;
        this.caseParent.occupant = this;
        System.out.println(this.getClass().getSimpleName());
    }
    
    /**
     * Attribue un batiment parent a une unite (change de batiment si l'unite a deja un parent)
     * @param b 
     */
    public void setBatimentParent(Batiment b)
    {
        this.batimentParent = null;
        this.caseParent = null;
        this.batimentParent = b;
    }
    
    /**
     * deplace l'unite vers une nouvelle case
     * @param nvCase 
     */
    public void deplacer(Case nvCase)
    {
        if(nvCase==null){
            this.detruire();
        } else{
            setCaseParent(nvCase);
        }
    }
    
    /**
     * Réparer les dégâts d'une unité.
     */
    public void reparer()
    {
        
    }
    
    /**
     * Détruire une unité.
     * @return 
     */
    public boolean detruire()
    {
        switch (this.getClass().getSuperclass().getSuperclass().getSimpleName()) {
            case "UniteCivile":
                this.joueur.unitesCiviles.remove(this);                
                break;
            case "UniteMilitaire":
                this.joueur.unitesMilitaires.remove(this);
                break;
        }
        this.joueur.unites.remove(this);
        this.caseParent.occupant = null;
        this.caseParent = null;
        
        return true;
    }
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionX()
    {
        if(caseParent!=null){
            return this.caseParent.X;
        }else{
            return -1;
        }
    }
    
    /**
     * retourne la position Y d'une unite
     * @return 
     */
    public int positionY()
    {
        if(this.caseParent!=null){
            return this.caseParent.Y;
        }else{
            return -1;
        }
    }
    
    /**
     * retourne une liste de coordonnees correspondant au cases vers lesquelles l'unite peut se deplacer
     */
    public void setMovableTiles()
    {
        int xStart, yStart, xFinish, yFinish;
        int x = this.positionX() + 1;
        int y = this.positionY() + 1;
        int l = this.distanceDeMvt;
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
    
    public void setMovableTilesForHelpBuilding()
    {
        int xStart, yStart, xFinish, yFinish;
        int x = this.positionX() + 1;
        int y = this.positionY() + 1;
        int l = this.distanceDeMvt;
        List<String> movableTypes = movableTypes();
        List<int[]> movableTiles = new ArrayList<>();
        int[] tiles = null;
        xStart = (x-l>0) ? (x-l) : 1;
        yStart = (y-l>0) ? (y-l) : 1;
        xFinish = (x+l<Play.tMap.getWidth())?(x+l):100;
        yFinish = (y+l<Play.tMap.getHeight())?(y+l):100;
        for (int i = xStart; i <= xFinish; i++){
            for(int j=yStart;j<=yFinish;j++){
                if((Math.abs(x-i)+Math.abs(y-j))<=l&&(movableTypes.contains(Game.plateau.cases.get(j-1).get(i-1).type())) && (Game.plateau.cases.get(j-1).get(i-1).occupant instanceof Batiment)){
                    tiles = new int[2];
                    tiles[0] = i;
                    tiles[1] = j;
                    movableTiles.add(tiles);
                    tiles = null;
                }
            }
        }
        AStar paths= new AStar(Play.tMap.getHeight(), Play.tMap.getWidth(), x, y, l, Game.plateau, movableTypes, movableTiles);
        movableTiles=paths.pathfind();
        Play.movableTiles=movableTiles;
        Play.state="Deplacement";
    }
    
    public void aiderBatir()
    {
        System.out.println("ICI LA FONCTION QUI PERMET A UN OUVRIER DAIDER A CONSTUIRE UN AUTRE BATIMENT");
    }

    public Case findExitTile() throws PasDePlaceException
    {
        for (int k = 0; k < 10; k++) {                  
          for (int i = 0; i < k*2+3; i++) {
                for (int j = 0; j < k*2+3; j++) {
                    int y = this.batimentParent.positionX() - 1-k + i;
                    int x = this.batimentParent.positionY() - 1-k + j;
                    if((x>0&&x<Play.tMap.getWidth())&&(y>0&&y<Play.tMap.getHeight())){
                        if((this.movableTypes().contains(Game.plateau.cases.get(x).get(y).type()))&&(Game.plateau.cases.get(x).get(y).occupant==null)){
                            return Game.plateau.cases.get(x).get(y);
                        }
                    }
                }
            }
        }
        throw new PasDePlaceException();
        
    }

    public void exitParent()
    {
        try {
            deplacer(findExitTile());
        } catch (PasDePlaceException ex) {
            Logger.getLogger(Unite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void predeplacer()
    {
        System.out.println("WOUHOUUU!");
    }
    
    /**
     * Retourne une liste de boutons correspondant aux actions que peut effectuer cette unite
     * @return 
     */
    public List<GameButton> getMenu()
    {
        int x = 810; int y = 110;  
        List<GameButton> list = new ArrayList<>();
        try {
            if (this.getConstructions() != null) {
                for (Map.Entry<String, Constructor> c : this.getConstructions().entrySet()) {
                    try {
                        list.add(new GameButton(810, y, new Image("Graphics/Images/BoutonSmall.png"), c.getKey(), UCT_Ouvrier.class.getDeclaredMethod("preConstruction", new Class[]{String.class, Constructor.class, Unite.class}), c.getValue(), new Image("Graphics/Units/Batiments/"+c.getValue().getName().substring(c.getValue().getName().lastIndexOf(".")+1)+"/sprite.png"),this));
                    } catch (NoSuchMethodException | SecurityException ex) {
                        Logger.getLogger(Unite.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    y += 30;
                }
            }
            
            for (Map.Entry<String, Method> m : this.getActions().entrySet()) {
                list.add(new GameButton(810, y, new Image("Graphics/Images/Bouton.png"), m.getKey(), m.getValue(), this));
                y += 50;
            }                
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
        
        return list;
    }
    
    public void setNom(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString(nom,810, 70); 
    }
    
    public void barreDeVie(Graphics g)
    {       
        int pointsDeVieManquants=this.pointsDeVie-this.pointsDeVieRestants;
        g.setLineWidth(5);
        g.setColor(Color.green);
        if(this.pointsDeVie==this.pointsDeVieRestants){
            g.drawLine(810, 95, 1010, 95);
        }
        else{
            g.drawLine(810, 95, 810+((200/this.pointsDeVie)*this.pointsDeVieRestants), 95);
            g.setColor(Color.red);
            g.drawLine(810+((200/this.pointsDeVie)*this.pointsDeVieRestants), 95, 1010, 95);
        }
        g.setLineWidth(1);
    }
    
    public void sideInfos(Graphics g)
    {
        this.setNom(g);
        this.barreDeVie(g);
    }
    
    /**
     * retourne la Sprite de l'unite
     * @return 
     */
    public Image getSprite()
    {
        try {
            return new Image("Graphics/Units/Unites/"+this.getClass().getSimpleName()+"/sprite.png");
        } catch (SlickException ex) {
            System.out.println("Erreur image:"+this.getClass().getSimpleName());
        }
        return null;
    }
    
   public List<String> movableTypes()
   {
       List<String> types=new ArrayList<>();
       return types;
   }
   
   public void finirConstruction()
   {
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
        
        str += "    [HEB] ";
        for (Unite u : this.unitesHebergees) {
            str += u.nom + " ";
        }
        str += "\n";
        
        return str;
    }
}