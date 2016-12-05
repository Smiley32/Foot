public class Joueur implements Playable {
    
    private Position positionInitiale;
    private Position pos;
    
    public Joueur(Position positionInitiale);
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
}