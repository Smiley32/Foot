public abstract class Joueur implements Playable {
    
    private Position positionInitiale;
    // Position actuelle du joueur
    protected Position pos;
    protected Equipe equipe;
   
    
    public Joueur(Position positionInitiale, Equipe equipe){
        this.positionInitiale = positionInitiale;
        this.pos = positionInitiale;
        this.equipe = equipe;
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
        // this.equipe.ajouterBut();
    }
    
    public void setPosition() {
        this.pos = this.positionInitiale;
    }
    //ajouter un comportement classique 
    //ajouter la fonction déplacement() et la fonction shoote()
    
    public Direction shoote(){
        return new Direction(Outils.rand(0,2)-1, Outils.rand(0,2)-1);
    }
    
    public Direction deplacement(){
        return new Direction(Outils.rand(0,2)-1, Outils.rand(0,2)-1);
    }
    

    
}
