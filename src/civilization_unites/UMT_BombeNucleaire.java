package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;

public class UMT_BombeNucleaire extends UniteMilitaireTerrestre
{
    public UMT_BombeNucleaire(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bombe nucléaire", 40, 0, 25, 0, 20, 13, 40, 10, 10, 5, caseParent, batimentParent);
    }
    
    @Override public boolean peutAttaquer(Unite unite)
    {
        if (super.peutAttaquer(unite)) {
            return true;
        } else {
            return false;
        }
    }
}
