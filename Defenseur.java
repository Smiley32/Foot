public class Defenseur extends Joueur {

    
    /*public Direction shoote (){
        if (equipe.getPositionBut().getLigne() < pos.getLigne()){
            return new Direction(0,-1);
        }
        return new Direction(0,1);
    }*/
    
    /*public Direction deplacement(Ballon ballon){
        if (pos.distanceAvec(ballon.getPosition()) < 4){
            return pos.seDirigerVers(ballon.getPosition());
        }
        else{
            return pos.seDirigerVers(equipe.getPositionBut());
        }
    }*/
    
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "D" + Outils.endColor();
    }
    
    public Defenseur(Position positionInitiale, Equipe equipe){
        super(positionInitiale, equipe);
    }
} 
