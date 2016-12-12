public abstract class Joueur implements Playable {
    
    protected Position positionInitiale;
    // Position actuelle du joueur
    protected Position pos;
    protected Equipe equipe;
    protected Terrain t;
    
    public Joueur(Terrain t, Position positionInitiale, Equipe equipe){
        this.positionInitiale = positionInitiale;
        this.pos = positionInitiale;
        this.equipe = equipe;
        this.t = t;
    }
    
    public Position getPosition() {
        return this.pos;
    }
    
    public void setPosition(Position p) {
        this.pos = p;
    }
    
    public boolean rencontreBalle(){
        return pos.distanceAvec(this.t.getBallon().getPosition()) == 0;
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
