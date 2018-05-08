package fr.lesprogbretons.seawar.ia.etat;

import fr.lesprogbretons.seawar.model.Orientation;
import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;
import fr.lesprogbretons.seawar.model.cases.CaseEau;
import fr.lesprogbretons.seawar.model.cases.CaseTerre;
import fr.lesprogbretons.seawar.model.map.Grille;

import java.util.ArrayList;
import java.util.HashSet;

public class Etat {

    private Partie partie; // besoin de la partie pour récuperrer la grille
    private Grille map; // TODO: pull request pour changer les visibilites des getters => done !

    public Etat(HashSet<Boat> navires, HashSet<CaseEau> phares) { //info des bateaux et des phares
        //TODO:
    }

    public Etat clone() {
        //TODO: cloner la grille ? (qui clone elle meme les bateaux,...)
        return null;
    }

    public void simulateAction(Action action) {
        //TODO: changer l'état suivant l'action
    }

    //TODO: cloner un etat, trouver les actions à faire...


    public ArrayList<Case> getMove(Boat boat) {
        if(boat.getMove() != 0) {
            return map.getCasesDisponibles(boat.getPosition(), 1);
        } else {
            return null;// pas de deplacement possible
        }
    }

}
