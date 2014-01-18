package civilization.unTour;

import civilization.game_engine.Game;
import civilization.game_engine.Play;
import civilization_joueurs.Joueur;

public class UnTour 
{
    public static Joueur joueurActif = Game.joueurs.get(0);
    public static int numero = 0;
    
    public UnTour()
    {
        //joueurActif=(joueurActif.equals(Game.j1))?Game.j2:Game.j1;
        int joueurSuivant = ( (Game.joueurs.indexOf(joueurActif) + 1) == Game.joueurs.size() ) ? 0 : Game.joueurs.indexOf(joueurActif) + 1;
        joueurActif = Game.joueurs.get(joueurSuivant);
        numero++;
        System.out.println(this.toString());
        Play.state="Nouveau Tour";
    }
       
    @Override
    public String toString()
    {
        return "Tour numero: "+numero+", Joueur Actif: "+joueurActif.pseudo;          
    }
}
