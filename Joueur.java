public class Joueur implements Playable {
    
    private Position positionInitiale;
    // Position actuelle du joueur
    private Position pos; 
    
    public Joueur(Position positionInitiale){
        this.positionInitiale = positionInitiale;
        this.pos = positionInitiale
    }
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
}
