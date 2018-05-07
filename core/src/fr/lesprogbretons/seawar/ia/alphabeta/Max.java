package fr.lesprogbretons.seawar.ia.alphabeta;


import fr.lesprogbretons.seawar.ia.etat.Etat;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.actions.PassTurn;

import java.util.HashSet;

import static java.lang.StrictMath.max;

public class Max extends Noeud {

    public Max(Etat etat){
        super(etat);
    }


    @Override
    public void genererFils() { //TODO: preciser le nombre d'etage de generation ?
        //TODO: creer les fils du noeud en cours en fonction de l'état
        //deplacement d'une case (le controller ne gère que des déplacements d'une case) + tir possible

        HashSet<Action> actions = getActionsPossible();
        for (Action action : actions) {
            Noeud nextAction = new Max(etat.clone());
            nextAction.getEtat().simulateAction(action); //mettre à jour l'état
            fils.add(nextAction);
            //TODO: generer les fils de nextAction => implementer avec une file ???
        }

        Noeud nextAction = new Min(etat.clone());// TODO: on le fait avec un Min ?
        nextAction.getEtat().simulateAction(new PassTurn(null));
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

    @Override
    public HashSet<Action> getActionsPossible() {
        //TODO: etudier les actions possible pour max (bateau du joueur1 par ex)
        return null;
    }


}
