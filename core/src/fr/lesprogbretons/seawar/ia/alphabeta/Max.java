package fr.lesprogbretons.seawar.ia.alphabeta;


import fr.lesprogbretons.seawar.ia.etat.Etat;

import static java.lang.StrictMath.max;

public class Max extends Noeud {

    public Max(Etat etat){
        super(etat);
    }

    @Override
    public int utilite() {
        //TODO: Creer une fonction heuristique qui retourne une valeur en fonction de l'etat
        return 0;
    }

    @Override
    public int alphabeta(int alpha, int beta) {
        if(fils == null || fils.isEmpty()) {
            return utilite();
        } else {
            for (Noeud noeud : fils) {
                alpha = max(alpha, noeud.alphabeta(alpha, beta));
                if (beta < alpha) break;
            }
            return alpha;
        }
    }
}
