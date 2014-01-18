/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization.unTour;

import civilization.game_engine.Game;
import civilization.game_engine.Play;
import civilization_joueurs.Joueur;

/**
 *
 * @author Nicolas
 */
public class UnTour {
    public static Joueur joueurActif=Game.j1;
    public static int numero=0;
    
        public UnTour(){
           joueurActif=(joueurActif.equals(Game.j1))?Game.j2:Game.j1;
            numero++;
            System.out.println(this.toString());
            Play.state="Nouveau Tour";
        }
       
    @Override
     public String toString(){
        return "Tour numero: "+numero+", Joueur Actif: "+joueurActif.pseudo;          
        }
}
