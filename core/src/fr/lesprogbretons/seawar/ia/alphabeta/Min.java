package fr.lesprogbretons.seawar.ia.alphabeta;


public class Min extends Noeud {

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
                alpha = min(beta, noeud.alphabeta(apha, beta));
                if (beta < alpha) break;
            }
            return a;
        }
    }
}
