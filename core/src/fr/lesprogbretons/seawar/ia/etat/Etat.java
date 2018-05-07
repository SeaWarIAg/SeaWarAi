package fr.lesprogbretons.seawar.ia.etat;

import fr.lesprogbretons.seawar.model.Orientation;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;
import fr.lesprogbretons.seawar.model.cases.CaseEau;
import fr.lesprogbretons.seawar.model.cases.CaseTerre;

import java.util.ArrayList;
import java.util.HashSet;

public class Etat {



    public Etat (HashSet<Boat> navires, HashSet<CaseEau> phares){ //info des bateaux et des phares

    }





    /**
     * //TODO: Nouvelle fonction pour l'IA
     * Fonction renvoyant un tableau de cases contenant toutes les cases sur lesquelles un bateau peut se déplacer depuis une case voulue
     *
     * @param c     : case de départ
     * @param ori   : orientation de départ
     * @return un tableau contenant toutes les cases sur lesquelles on peut se déplacer
     */
    public ArrayList<Case> getCasesForOneMove(Case c, Orientation ori) {
        ArrayList<Case> tab = new ArrayList<>();
        if (ori == Orientation.NORD) {
            getCasesDisponible(getCaseNordOuest(c), tab);
            getCasesDisponible(getCaseNord(c), tab);
            getCasesDisponible(getCaseNordEst(c), tab);
        } else if (ori == Orientation.NORDOUEST) {
            getCasesDisponible(getCaseSudOuest(c), tab);
            getCasesDisponible(getCaseNord(c), tab);
            getCasesDisponible(getCaseNordOuest(c), tab);
        } else if (ori == Orientation.SUDOUEST) {
            getCasesDisponible(getCaseSudOuest(c), tab);
            getCasesDisponible(getCaseSud(c), tab);
            getCasesDisponible(getCaseNordOuest(c), tab);
        } else if (ori == Orientation.SUD) {
            getCasesDisponible(getCaseSudOuest(c), tab);
            getCasesDisponible(getCaseSud(c), tab);
            getCasesDisponible(getCaseSudEst(c), tab);
        } else if (ori == Orientation.SUDEST) {
            getCasesDisponible(getCaseNordEst(c), tab);
            getCasesDisponible(getCaseSud(c), tab);
            getCasesDisponible(getCaseSudEst(c), tab);
        } else if (ori == Orientation.NORDEST) {
            getCasesDisponible(getCaseNordEst(c), tab);
            getCasesDisponible(getCaseNord(c), tab);
            getCasesDisponible(getCaseSudEst(c), tab);
        }
        return tab;
    }



    /**
     * Procédure permettant d'avoir toutes les accessibles depuis une case à une certaine distance
     *
     * @param c     : Case dont on veut les cases voisines
     * @param range : Distance à laquelle on veut les voisins
     * @param tab   : Tableau contenant les cases voisines
     */
    private void getCasesDisponible(Case c, int range, ArrayList<Case> tab) {
        if (c != null) {
            if (!(tab.contains(c)) && !(c instanceof CaseTerre) && !(casePossedeBateaux(c))) {
                tab.add(c);
            }

            if (range != 0 && !(c instanceof CaseTerre) && !(casePossedeBateaux(c))) {
                if (c.getX() > 0) {
                    getCasesDisponible(getCaseSud(c), (range - 1), tab);
                }
                if (c.getY() < largeur - 1) {
                    if ((c.getY() % 2 == 0 && c.getX() > 0) || c.getY() % 2 == 1) {
                        getCasesDisponible(getCaseSudEst(c), (range - 1), tab);
                    }
                }
                if (c.getY() < largeur - 1) {
                    if ((c.getY() % 2 == 1 && c.getX() < hauteur - 1) || c.getY() % 2 == 0) {
                        getCasesDisponible(getCaseNordEst(c), (range - 1), tab);
                    }
                }
                if (c.getY() > 0) {
                    if ((c.getY() % 2 == 0 && c.getX() > 0) || c.getY() % 2 == 1) {
                        getCasesDisponible(getCaseSudOuest(c), (range - 1), tab);
                    }
                }
                if (c.getY() > 0) {
                    if ((c.getY() % 2 == 1 && c.getX() < hauteur - 1) || c.getY() % 2 == 0) {
                        getCasesDisponible(getCaseNordOuest(c), (range - 1), tab);
                    }
                }
                if (c.getX() < hauteur - 1) {
                    getCasesDisponible(getCaseNord(c), (range - 1), tab);
                }
            }
        }
    }
}
