package civilization;


import civilization_unites.UCM_BateaudePeche;
import civilization_unites.UCT_Ouvrier;
import civilization_unites.UMM_Sousmarin;

public class Civilization {

    public static void main(String[] args) 
    {
        UCM_BateaudePeche monBateau = new UCM_BateaudePeche();
        System.out.println(monBateau);
        
        UCT_Ouvrier monOuvrier = new UCT_Ouvrier();
        System.out.println(monOuvrier);
        
        UMM_Sousmarin monSM = new UMM_Sousmarin();
        System.out.println(monSM);
    }

}