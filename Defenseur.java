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
        } else if (pos.distanceAvec(this.equipe.getPositionBut()) > 4){
            return pos.seDirigerVers(equipe.getPositionBut());
        } else {
            return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
        }
    }
    
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "D" + Outils.endColor();
    }
    
    public Defenseur(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);
    }
} 
