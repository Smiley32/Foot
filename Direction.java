/**
 * Classe Direction
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Direction {
    private int x;
    private int y;

    /**
     * Constructeur vide créant une direction nulle
     */
    public Direction() {
        this(0,0);
    }

    /**
     * Création d'une direction grace aux paramètres
     *
     * @param x         Entier {-1,0,1} pour à gauche, rien, à droite
     * @param y         Entier {-1,0,1} pour haut, rien, bas
     */
    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère la coordonnée X de la direction
     *
     * @return          Direction X
     */
    public int getX(){
        return this.x;
    }

    /**
     * Récupère la coordonnée Y de la direction
     *
     * @return          Direction Y
     */
    public int getY(){
        return this.y;
    }
}
