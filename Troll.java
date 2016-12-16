/**
 * Classe Troll
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Troll implements Playable {
    private Position pos;
    private Terrain t;

    /**
     * Création d'un Troll
     *
     * @param t         Terrain dans lequel le troll joue
     * @param posInit   Position initiale du troll
     */
    public Troll(Terrain t, Position posInit) {
        this.pos = posInit;
        this.t = t;
    }

    /**
     * Envoie la nouvelle Direction du ballon, après que le troll l'aie frappé
     *
     * @return          La nouvelle direction du ballon
     */
    public Direction shoote() {
        return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
    }

    /**
     * Retourne la direction dans laquelle le troll doit se déplacer
     *
     * @return          La nouvelle direction
     */
    public Direction deplacement() {
        return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
    }

    /**
     * Affichage d'un troll
     *
     * @return          Chaine permettant de l'afficher sur le terrain
     */
    public String toString() {
        return Outils.beginColor("green") + "T" + Outils.endColor();
    }

    /**
     * Signale si le troll rencontre la balle
     *
     * @return      Booléen Vrai si le troll rencontre la balle
     */
    public boolean rencontreBalle() {
        return pos.distanceAvec(this.t.getBallon().getPosition()) == 0;
    }

    /**
     * Récupère la position du troll
     *
     * @return      Position du troll
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Modifie la position du troll
     *
     * @param p         Nouvelle position
     */
    public void setPosition(Position p) {
        this.pos = p;
    }

    /**
     * Modifie la position du troll par défaut (simple déplacement)
     */
    public void setPosition() {
        deplacement();
    }
}
