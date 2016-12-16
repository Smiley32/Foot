/**
 * Classe Ballon
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Ballon {
    private Position pos;
    private Direction dir;
    private Playable derniereFrappe;

    /**
     * Constructeur définissant un nouveau ballon a une position et une direction par defaut
     */
    public Ballon() {
        this.pos = new Position();
        this.dir = new Direction();
    }

    /**
     * Constructeur définissant un nouveau ballon une direction par defaut
     *
     * @param p  La Position initiale du ballon
     */
    public Ballon(Position p) {
        this.pos = p;
        this.dir = new Direction();
    }

    /**
     * Création d'un Ballon
     *
     * @param p  La Position initiale du ballon
     * @param d La Direction initiale du ballon
     */
    public Ballon(Position p, Direction d) {
        this.pos = p;
        this.dir = d;
    }

    /**
     * Définir une nouvelle Position pour le ballon
     *
     * @param p  La nouvelle Position
     */
    public void setPosition(Position p) {
        this.pos = p;
    }

    /**
     * Récupère la Position du ballon
     *
     * @return      Position du ballon
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Définir une nouvelle Direction pour le ballon
     *
     * @param d  La nouvelle Direction
     */
    public void setDirection(Direction d) {
        this.dir = d;
    }

    /**
     * Récupère la Direction du ballon
     *
     * @return      Direction du ballon
     */
    public Direction getDirection() {
        return this.dir;
    }
}
