package civilization_unites;

import civilization.Case;
import civilization.game_engine.Game;
import civilization.game_engine.GameButton;
import civilization.game_engine.Play;
import civilization_batiments.*;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import static civilization_unites.UCA_AviondeLigne.actions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UCT_Ouvrier extends UniteCivileTerrestre
{    
    public Constructor aConstruire;
    public String typeAConstruire;
    
    public UCT_Ouvrier(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Ouvrier", 1, 0, 0, 2, 2, 2, 10, caseParent, batimentParent, 5);
    }
    
    public static final Map<String, Constructor> constructions = new LinkedHashMap<>(); 
    static {
        try {
            constructions.put("Construire Aeroport", Aeroport.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Constuire Port", Port.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Constuire Caserne", Caserne.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Constuire Scierie", Scierie.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Construire Ferme", Ferme.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Construire Maison", Maison.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Construire Tour", Tour.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Construire Mur", Mur.class.getConstructor(Joueur.class, Case.class));
            constructions.put("Construire Mine", Mine.class.getConstructor(Joueur.class, Case.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Map<String, Constructor> getConstructions()
    {
        return constructions;
    }
    
    
    public List<int[]> getBuildableTiles()
    {
        List<int[]> buildableTiles = new ArrayList<>();
        int x=this.positionX()+1;
        int y=this.positionY()+1;
        for(int i=-1;i<=1;i++){
            for (int j = -1; j <= 1; j++) {
            if((x+i!=0&&x+i<=Play.tMap.getWidth())&&(y+j!=0&&y+j<=Play.tMap.getWidth())){
                if(buildable(Game.plateau.getCase(x+i, y+j))&&Game.plateau.getCase(x+i, y+j).occupant==null){
                    int[] tile = new int[2];
                    tile[0]=x+i;
                    tile[1]=y+j;
                    buildableTiles.add(tile);
                }
            }
          }
        }

        return buildableTiles;
    }
    
    public boolean buildable(Case c)
    {
        List<String> rules = new ArrayList<>();
        if(aConstruire.getDeclaringClass().getSimpleName().equals("Port")){
            rules.add("Eau");
        }
        else{
            rules.add("Sable");
            rules.add("Terre");
            rules.add("Foret");
        }
     return (rules.contains(c.type()));
    }
    
    public void preConstruction(String s, Constructor c)
    {
        this.aConstruire=c;
        this.typeAConstruire=s;
        Play.state="Construction";
        Play.placeableTiles=getBuildableTiles();
    }
    
    public void construire(Case c)
    {
        try {
            this.aConstruire.newInstance(this.joueur,c);
        } catch (InstantiationException|InvocationTargetException|IllegalArgumentException|IllegalAccessException ex) {
            Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    @Override
    public List<GameButton> getMenu()
    {
      List<GameButton> list = new ArrayList<>();
      int posY=100;
        try {
            for(Constructor c : this.getConstructions().values()){ 
                try {
                    list.add(new GameButton(810, posY, new Image("Graphics/Images/Bouton.png"),c.getName().substring(c.getName().lastIndexOf(".")+1),UCT_Ouvrier.class.getDeclaredMethod("preConstruction",String.class,Constructor.class),c,new Image("Graphics/Units/Batiments/"+c.getName().substring(c.getName().lastIndexOf(".")+1)+"/sprite.png"),this));
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                }
                posY+=50;
            }
            try {
                    list.add(new GameButton(810, posY, new Image("Graphics/Images/Bouton.png"),"Deplacer",Unite.class.getDeclaredMethod("setMovableTiles"),this));
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SlickException ex) {
            System.out.println("Erreur Creation Menu Action");
        }
      return list;
    }

    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Déplacer", Unite.class.getDeclaredMethod("setMovableTiles"));
            actions.put("Soigner", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Tuer", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UCT_Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return null;
    }
}

