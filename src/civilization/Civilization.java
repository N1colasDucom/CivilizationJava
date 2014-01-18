package civilization;

import civilization_batiments.Aeroport;
import civilization_joueurs.Joueur;

public class Civilization 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
            Case maCase = new Case(i, i, i);
            Aeroport aero = new Aeroport(j1, maCase);
        }
        
        System.out.println(j1);
    }
}