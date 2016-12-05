public class Ballon {
    private Position pos;
    private Direction dir;
    private Playable derniereFrappe;
    
    public Ballon() {
        this.pos = new Position();
        this.dir = new Direction();
    }
    
    public Ballon(Position p) {
        this.pos = p;
        this.dir = new Direction();
    }
    
    public Ballon(Position p, Direction d) {
        this.pos = p;
        this.dir = d;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setDirection(Direction d) {
        this.dir = d;
    }
    
    public Direction getDirection() {
        return this.dir;
    }
    
    public void setDerniereFrappe(Playable p) {
        this.derniereFrappe = p;
    }
    
    public Playable getDerniereFrappe() {
        return this.derniereFrappe;
    }
}