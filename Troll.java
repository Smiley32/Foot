public class Troll implements Playable {
    private Position pos;
    
    public Troll(Position posInit) {
        this.pos = posInit;
    }

    public Direction shoote() {
        return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
    }
    
    public Direction deplacement() {
        return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
    }
    
    public String toString() {
        return Outils.beginColor("green") + "T" + Outils.endColor();
    }
    
    public boolean rencontreBalle(Ballon ballon) {
        if (pos.distanceAvec (ballon.getPosition()) == 0) 
            return true;
        else 
            return false;
    }
    
    public void marqueBut() {
    
    }
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
    
    public void setPosition() {
        deplacement();
    }
}
