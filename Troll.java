public class Troll implements Playable {
    private Position pos;
    private Terrain t;
    
    public Troll(Terrain t, Position posInit) {
        this.pos = posInit;
        this.t = t;
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
    
    public boolean rencontreBalle() {
        return pos.distanceAvec(this.t.getBallon().getPosition()) == 0;
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
