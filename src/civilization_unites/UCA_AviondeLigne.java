package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UCA_AviondeLigne extends UniteCivileAerien
{        
    public UCA_AviondeLigne(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Avion de ligne", 5, 0, 6, 0, 10, 6, 5, caseParent, batimentParent);
    }
    
    public void rejoindreAeroport()
    {
        System.out.println("TODO");
    }
}
