public abstract class Joueur implements Playable {
    
    private Position positionInitiale;
    // Position actuelle du joueur
    private Position pos;
    private Equipe equipe;
   
    
    public Joueur(Position positionInitiale, Equipe equipe){
        this.positionInitiale = positionInitiale;
        this.pos = positionInitiale;
    }
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
    
    public boolean rencontreBalle(Ballon ballon){
        if (pos.distanceAvec (ballon.getPosition()) == 0) 
            return true;
        else 
            return false;
    }
    
    public void marqueBut(){
        this.equipe.ajouterBut();
    }
    
}
