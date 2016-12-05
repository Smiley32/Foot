public abstract class Joueur implements Playable {
    
    
    private static int rand(int min, int max) {
        return (int)(Math.random() * (max - min -1)) + min;
    }
    
    private Position positionInitiale;
    // Position actuelle du joueur
    protected Position pos;
    protected Equipe equipe;
   
    
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
    
    public void setPosition() {
        this.pos = this.positionInitiale;
    }
    //ajouter un comportement classique 
    //ajouter la fonction déplacement() et la fonction shoote()
    
    public Direction shoote(){
        return new Direction(rand(0,2)-1,rand(0,2)-1);
    }
    
    public Direction deplacement(Ballon ballon){
        return new Direction(rand(0,2)-1,rand(0,2)-1);
    }
    

    
}
