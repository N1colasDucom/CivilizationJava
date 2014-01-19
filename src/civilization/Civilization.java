package civilization;

import civilization_batiments.Aeroport;
import civilization_joueurs.Joueur;
import civilization_unites.UCA_AviondeLigne;
import civilization_unites.UCT_Ouvrier;

public class Civilization 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        Case maCase = new Case(42, 42, 42);
        Aeroport aero = new Aeroport(j1, maCase);
        UCA_AviondeLigne monAvion = new UCA_AviondeLigne(j2, null, aero);
        UCT_Ouvrier monOuvrier = new UCT_Ouvrier(j2, null, null);
        System.out.println(aero.hebergerUnite(monAvion));
        System.out.println(aero.hebergerUnite(monOuvrier));
        
    }
}