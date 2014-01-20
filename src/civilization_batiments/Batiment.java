package civilization_batiments;

import civilization.Case;
import civilization.game_engine.GameButton;
import civilization_exceptions.RessourcesInsuffisantesException;
import civilization_joueurs.Joueur;
import civilization_unites.UCT_Ouvrier;
import civilization_unites.Unite;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Batiment 
{    
    public Joueur joueur;
    public int pointsDeVie, pointsDeVieRestants;
    public String statut;
    public int niveau;
    public int requisNourriture, requisBois, requisFer, requisOr, prodOr, prodBois, prodFer, prodNourriture, tempsConstruction, ouvriersMax;
    public ArrayList<UCT_Ouvrier> ouvriersQuiConstruisent = new ArrayList<>();
    public ArrayList<Unite> unitesHebergees = new ArrayList<>();

    public Case caseParent;
    
    public boolean actionDuTourRealisee = false;
    
    public abstract Map<String, Constructor> getConstructions();
    public abstract Map<String, Method> getActions();
        
    /**
     * Construit un batiment
     * @param j Propriétaire du batiment (Joueur)
     * @param c Case sur laquelle sera contruit le bâtiment
     * @param t Temps de construction
     * @param p Points de vie du bâtiment
     * @param or Quantité d'or requise
     * @param bois Quantité de boise requise
     * @param fer Quantité de fer requise
     * @param nourriture Quantité de nourriture requise
     * @param ouvriersMax Nombre d'ouvriers pouvant participer à la construction du bâtiment
     * @param prodOr Quantité d'or produite par tour
     * @param prodBois Quantité de bois produite par tour
     * @param prodFer Quantité de fer produite par tour
     * @param prodNourriture Quantité de nourriture produite par tour
     */
    public Batiment(
            Joueur j, Case c, int t, int p,
            int or, int bois, int fer, int nourriture, int ouvriersMax,
            int prodOr, int prodBois, int prodFer, int prodNourriture
    ) {
        this.pointsDeVie = p;
        this.pointsDeVieRestants = this.pointsDeVie;
        this.requisOr = or;
        this.requisBois = bois;
        this.requisFer = fer;
        this.requisNourriture = nourriture;
        this.prodOr = prodOr;
        this.prodBois = prodBois;
        this.prodFer = prodFer;
        this.prodNourriture = prodNourriture;
        this.ouvriersMax = ouvriersMax;
        this.tempsConstruction = t;
        this.niveau = 1;
        this.statut = "En construction";
       
       try {
            if (j.disposeDesRessourcesNessairesPourAcheter(this)) {
                this.joueur = j;
                this.joueur.ajouterBatiment(this);
                this.caseParent = c;
                this.caseParent.occupant = this;
            } else {
                throw new RessourcesInsuffisantesException();
            }
        } catch (RessourcesInsuffisantesException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean reparer()
    {
        System.out.println("REPARATION DE : \n" + this.toString());
        return true;
    }
    
    public void augmenterNiveau()
    {
        
    }
    
    /**
     * Détruit un bâtiment
     * @return boolean
     */
    public boolean detruire()
    {
        this.caseParent.occupant = null;
        this.joueur.batiments.remove(this);
        
        return true;
    }
    
    public void preHebergerUnite()
    {
        System.out.println("Batiment.java > preHebergerUnite() pour appeler hebergerUnite() ensuite?");
    }
    
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
        joueur.ressourcesNourriture += this.prodNourriture;
    }
    
    /**
     * retourne la Sprite du batiment
     * @return 
     */
    public Image getSprite()
    {
        try {
            return new Image("Graphics/Units/Batiments/"+((!this.statut.equals("En construction"))?this.getClass().getSimpleName():"Construction")+"/sprite.png");
        } catch (SlickException ex) {
            System.out.println("Erreur image:"+this.getClass().getSimpleName());
        }
        
        return null;
    }
    
    /**
     * Attribue une case parent a un batiment
     * @param c 
     */
    public void setCaseParent(Case c)
    {
        if (this.caseParent!=null) {
            this.caseParent.occupant=null;
        }      
        this.caseParent=c;
        this.caseParent.occupant=this;
        System.out.println(this.getClass().getSimpleName());
    }
    
        /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionX()
    {
        return this.caseParent.X;
    }
    
    
    /**
     * retourne la position X d'une unite
     * @return 
     */
    public int positionY()
    {
        return this.caseParent.Y;
    }
    
    public void setNom(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString(this.getClass().getSimpleName(),810, 70); 
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
        barreDeVie(g);
    }
    
    /**
     * retourne une liste de boutons correspondant aux actions que peut effectuer ce batiment
     * @return 
     */
    public List<GameButton> getMenu()
    {
        List<GameButton> list = new ArrayList<>();
        int posY=100;
        
        try {
            if (this.getConstructions() != null) {
                for (Map.Entry<String, Constructor> c : this.getConstructions().entrySet()) {
                    list.add(new GameButton(810, posY, new Image("Graphics/Images/BoutonSmall.png"), c.getKey(), c.getValue(), new Image("Graphics/Units/Unites/"+c.getValue().getName().substring(c.getValue().getName().lastIndexOf(".")+1)+"/sprite.png"), this));
                    posY += 30;
                }
            }
            
            for (Map.Entry<String, Method> m : this.getActions().entrySet()) {
                list.add(new GameButton(810, posY, new Image("Graphics/Images/Bouton.png"), m.getKey(), m.getValue(), this));
                posY+=50;
            }
       
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
        
        return list;
    }
    
    @Override public String toString()
    {
        String str = "";
        str += this.getClass().getSimpleName() + "\n";
        
        str += "    [OUVR] ";
        for (UCT_Ouvrier ou : this.ouvriersQuiConstruisent) {
            str += ou.nom + " ";
        }
        str += "\n";
        
        return str;
    }
}