package civilization;

import civilization_batiments.Aeroport;
import civilization_joueurs.Joueur;
import civilization_unites.UCA_AviondeLigne;
import civilization_unites.UCT_Ouvrier;
import civilization_unites.UMM_PorteAvions;

public class Civilization 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException 
    {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        
        Case maCase = new Case(42, 42, 42);
        Aeroport aero = new Aeroport(j1, maCase);
        UCA_AviondeLigne monAvion = new UCA_AviondeLigne(j2, maCase, aero);
        UMM_PorteAvions monPorteAvions = new UMM_PorteAvions(j2, maCase, aero);
        monPorteAvions.hebergerUnite(monAvion);
        System.out.println(monPorteAvions);
        
    }
}