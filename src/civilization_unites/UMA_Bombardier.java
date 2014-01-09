package civilization_unites;

import civilization_joueurs.Joueur;

public class UMA_Bombardier extends UniteMilitaireAerien
{
    public static String nom = "Bombardier";
    
    public UMA_Bombardier(Joueur _joueur)
    {
        super(_joueur, UMA_Bombardier.nom, 6, 0, 8, 0, 10, 12, 10, 10, 2, 10);
    }
}