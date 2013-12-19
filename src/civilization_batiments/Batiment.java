/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization_batiments;

import civilization.Joueur;

/**
 *
 * @author Nicolas
 */
public abstract class Batiment {
    
    int pointsDeVie;
    int tempsConstruction;
    Joueur Proprietaire;
    
    public void Batiment(Joueur j){
       Proprietaire=j;
       Proprietaire.ajouterBatiment(this);
    }
    
}


