package civilization.unTour;

import civilization.game_engine.Game;
import civilization.game_engine.Play;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import civilization_unites.Unite;

public class UnTour 
{
    public static Joueur joueurActif = Game.joueurs.get(0);
    public static int numero = 0;
    public static int numeroFactis = 0;
    
    /**
     * Passe au joueur suivant une fois le tour terminé.
     */
    public UnTour()
    {
        // Actions sur le joueur actuel avant de passer au tour suivant...
        ajouterLesRessourcesProduitesDuJoueurEnCours();
        resetActionsRealisees();
        System.out.println("Récapitulatif du Joueur " + joueurActif.pseudo + " :");
        System.out.println(joueurActif);
        
        // Passage au joueur suivant...
        joueurActif = Game.joueurs.get(((Game.joueurs.indexOf(joueurActif) + 1) == Game.joueurs.size()) ? 0 : (Game.joueurs.indexOf(joueurActif) + 1));
        numero++; numeroFactis = numero/Game.joueurs.size();
        Play.state="Nouveau Tour";
    }
    
    /**
     * Ajoute les ressources créeés par les batiments d'un joueur au dit joueur.
     */
    private void ajouterLesRessourcesProduitesDuJoueurEnCours()
    {
        for (Batiment b : joueurActif.batiments) {
            b.produireDesRessources(joueurActif);
        }
        
        for (Unite u : joueurActif.unites) {
            u.produireDesRessources(joueurActif);
        }
    }
    
    private void resetActionsRealisees()
    {
        for (Batiment b : joueurActif.batiments) {
            b.actionDuTourRealisee = false;
        }
        
        for (Unite u : joueurActif.unites) {
            u.actionDuTourRealisee = false;
        }
    }
       
    @Override
    public String toString()
    {
        return "Tour numero: "+numero+", Joueur Actif: "+joueurActif.pseudo;          
    }
}
