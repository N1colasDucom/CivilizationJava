package civilization_unites;

import civilization_joueurs.Joueur;

public class UMA_Chasseur extends UniteMilitaireAerien
{
    public static String nom = "Chasseur";
    
    public UMA_Chasseur(Joueur _joueur)
    {
        super(_joueur, UMA_Chasseur.nom, 8, 0, 9, 0, 11, 10, 9, 12, 1, 10);
    }
}