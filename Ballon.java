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
     * @param Position  La Position initiale du ballon
     */
    public Ballon(Position p) {
        this.pos = p;
        this.dir = new Direction();
    }
    
    /**
     * Création d'un Ballon
     *
     * @param Position  La Position initiale du ballon
     * @param Direction La Direction initiale du ballon
     */
    public Ballon(Position p, Direction d) {
        this.pos = p;
        this.dir = d;
    }
    
    /**
     * Définir une nouvelle Position pour le ballon
     *
     * @param Position  La nouvelle Position
     */
    public void setPosition(Position p) {
        this.pos = p;
    }
    
    /**
     * Récupère la Position du ballon
     */
    public Position getPosition() {
        return this.pos;
    }
    
    /**
     * Définir une nouvelle Direction pour le ballon
     *
     * @param Direction  La nouvelle Direction
     */
    public void setDirection(Direction d) {
        this.dir = d;
    }
    
    /**
     * Récupère la Direction du ballon
     */
    public Direction getDirection() {
        return this.dir;
    }
    
    /**
     * Définir le dernier joueur a avoir frappé le ballon
     *
     * @param Playable Une personne jouant
     */
    public void setDerniereFrappe(Playable p) {
        this.derniereFrappe = p;
    }
    
    /**
     * Récupère la dernière personne à avoir tapé le ballon
     */
    public Playable getDerniereFrappe() {
        return this.derniereFrappe;
    }
}
