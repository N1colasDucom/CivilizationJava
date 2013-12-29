package civilization;

import civilization_joueurs.Joueur;
import civilization_unites.*;

public class Civilization {

    public static void main(String[] args) 
    {
        Joueur j1 = new Joueur("Nicolas");
        Joueur j2 = new Joueur("Valentin");
        
        UCA_AviondeLigne unAvion = new UCA_AviondeLigne(j2);
        
        System.out.println(j2);
    }
}