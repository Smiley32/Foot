public class Milieu extends Joueur {

    
    public Direction shoote(){
        if(equipe.getPositionBut().getLigne() < pos.getLigne()) {
            return new Direction(0,1);
        }
        return new Direction(0,-1);
    }
    
    public Direction deplacement() {
        if(pos.distanceAvec(this.t.getBallon().getPosition()) < 3){
            return pos.seDirigerVers(this.t.getBallon().getPosition());
        } else if (pos.distanceAvec(this.t.getBallon().getPosition()) > 6){
            return pos.seDirigerVers(positionInitiale);
        } else {
            return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
        }
    }
    
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "M" + Outils.endColor();
    }
    
    public Milieu(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);
    }
} 