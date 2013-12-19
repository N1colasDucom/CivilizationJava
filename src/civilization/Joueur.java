/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civilization;

import civilization_batiments.Batiment;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Joueur {
    int nourriture;
    int bois;
    int or;
    int fer;
    ArrayList<Batiment> batiments= new ArrayList<Batiment>();
    
    public void ajouterBatiment(Batiment b){
        this.batiments.add(b);
    }
}
