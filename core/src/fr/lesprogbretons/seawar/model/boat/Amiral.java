package fr.lesprogbretons.seawar.model.boat;

import fr.lesprogbretons.seawar.model.cases.Case;
import fr.lesprogbretons.seawar.model.Player;

import java.io.Serializable;

/**
 * Classe Amiral : sous-classe de Boat
 */
public class Amiral extends Boat implements Serializable {

    public Amiral(Case c, Player p) {
        super(c, p);
        move = 3;
        moveAvailable = move;
        maxHp = 100;
        hp = maxHp;
        dmgMainCanon = 50;
        reloadMainCanon = 4;
        dmgSecCanon = 30;
        reloadSecCanon = 2;
    }

    public Object clone() {
        Amiral clone = new Amiral(this.getPosition(), null); // le joueur ne semble pas servir dans le modele
        clone.setAlive(this.isAlive());
        clone.setEstBloque(this.isEstBloque());
        clone.setCanonSelectionne(this.getCanonSelectionne());
        clone.setMoveAvailable(this.getMoveAvailable());
        clone.setShootTaken(this.getShootTaken());
        clone.setOrientation(this.getOrientation());
        clone.setMainCD(this.getMainCD());
        clone.setSecCD(this.getSecCD());
        clone.setHp(this.getHp());

        return clone;
    }


    @Override
    public String toString() {
        return "Amiral";
    }
}
