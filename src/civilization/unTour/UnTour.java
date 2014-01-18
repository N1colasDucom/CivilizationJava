package civilization.unTour;

import civilization.game_engine.Game;
import civilization.game_engine.Play;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UnTour 
{
    public static Joueur joueurActif = Game.joueurs.get(0);
    public static int numero = 0;
    
    public UnTour()
    {
        ajouterLesRessourcesProduitesDuJoueurEnCours();
        
        joueurActif = Game.joueurs.get(((Game.joueurs.indexOf(joueurActif) + 1) == Game.joueurs.size()) ? 0 : (Game.joueurs.indexOf(joueurActif) + 1));
        numero++;
        
        System.out.println(this.toString());
        Play.state="Nouveau Tour";
    }
    
    private void ajouterLesRessourcesProduitesDuJoueurEnCours()
    {
        for (Batiment b : joueurActif.batiments) {
            joueurActif.ressourcesBois += b.prodBois;
            joueurActif.ressourcesFer += b.prodFer;
            joueurActif.ressourcesNourriture += b.prodNourriture;
            joueurActif.ressourcesOr += b.prodOr;
        }
    }
       
    @Override
    public String toString()
    {
        return "Tour numero: "+numero+", Joueur Actif: "+joueurActif.pseudo;          
    }
}
