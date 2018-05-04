package fr.lesprogbretons.seawar.ia.alphabeta;

import java.util.HashSet;

public abstract class Noeud {

    private Etat etat;
    private HashList<Noeud> fils;


    /**
     * Constructeur :
     *
     */
    Noeud(Etat etat) {
        this.etat = etat;
    }
    private Etat etat;
    private HashSet<Noeud> fils;


    private void genererFils() {
        //TODO: creer les fils du noeud en cours en fonction de l'état

    }

    public abstract int utilite();
    public abstract int alphabeta(int alpha, int beta);
}
