package civilization;


import civilization_joueurs.Joueur;
import civilization_unites.*;


public class Civilization {

    public static void main(String[] args) 
    {

        Joueur j1 = new Joueur("Nicolas");
        Joueur j2 = new Joueur("Valentin");
        
        UCA_AviondeLigne unAvion = new UCA_AviondeLigne(j2);
        UCA_AviondeLigne unAvion2 = new UCA_AviondeLigne(j2);
        UCA_AviondeLigne unAvion3 = new UCA_AviondeLigne(j2);
        System.out.println(j2);
       
        System.out.println(unAvion.getClass().getSuperclass().getSuperclass().getSuperclass().getSimpleName());
    }

}