public class Defenseur extends Joueur {

    
    public Direction shoote(){
        if(equipe.getPositionBut().getLigne() < pos.getLigne()) {
            return new Direction(0,-1);
        }
        return new Direction(0,1);
    }
    
    public Direction deplacement() {
        if(pos.distanceAvec(this.t.getBallon().getPosition()) < 6){
            return pos.seDirigerVers(this.t.getBallon().getPosition());
        } else {
            return pos.seDirigerVers(equipe.getPositionBut());
        }
    }
    
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "D" + Outils.endColor();
    }
    
    public Defenseur(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);
    }
} 
