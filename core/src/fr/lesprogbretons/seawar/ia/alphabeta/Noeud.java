package fr.lesprogbretons.seawar.ia.alphabeta;

import fr.lesprogbretons.seawar.ia.etat.Etat;

import java.util.HashSet;

public abstract class Noeud {

    protected Etat etat;
    protected HashSet<Noeud> fils;


    /**
     * Constructeur :
     *
     */
    Noeud(Etat etat) {
        this.etat = etat;
    }

    private void genererFils() {
        //TODO: creer les fils du noeud en cours en fonction de l'état

    }

    public abstract int utilite();
    public abstract int alphabeta(int alpha, int beta);
}
