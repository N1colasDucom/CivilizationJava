package civilization_unites;

import civilization_joueurs.Joueur;

public class UCA_AviondeLigne extends UniteCivileAerien
{    
    /**
     * Crée une un Avion de Ligne, Unité Civile Aérienne.
     * @param _joueur
     */
    public UCA_AviondeLigne(Joueur _joueur)
    {
        super(_joueur, 5, 0, 6, 0, 10, 6);
    }
}
