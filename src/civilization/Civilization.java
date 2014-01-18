package civilization;


import civilization_joueurs.Joueur;
import civilization_unites.UCT_Ouvrier;
import civilization_unites.UMT_Soldat;


public class Civilization 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        UMT_Soldat monSoldat = new UMT_Soldat(j2, null, null);
        UCT_Ouvrier sonOuvrier = new UCT_Ouvrier(j1, null, null);
        System.out.println(sonOuvrier.peutAttaquer(monSoldat));
        
        //Aeroport monAeroport = new Aeroport();
       // Aeroport monAeroport = new Aeroport(j1);
        
        
        // Pour executer les constructeurs
        /*for (Constructor c : monAeroport.getConstructions().values()) {
            try {
                System.out.println(c.newInstance(j1, null, null));       
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Civilization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // Pour lister + executer les actions
        for (Method m : monAeroport.getActions().values()) {
            try {
                System.out.println(m.getName());
                m.invoke(monAeroport);
        Aeroport monMur = new Aeroport();
        
        /*
        // Pour executer les constructeurs
        for (Constructor c : monAeroport.getConstructions().values()) {
            try {
                System.out.println(c.newInstance(j1, null, null));
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Civilization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        /*
        // Pour lister + executer les actions
        for (Method m : monMur.getActions().values()) {
            try {
                System.out.println(m.getName());
                m.invoke(monMur);
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Civilization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
}