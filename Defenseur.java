public class Defenseur extends Joueur {

    
    public Direction shoote (){
        if (equipe.getPositionBut().getLigne() < pos.getLigne()){
            return Direction(0,-1);
        }
        return Direction(0,1);
    }
    
    public Direction deplacement(Ballon ballon){
        if (pos.distanceAvec(ballon.getPosition()) < 4){
            return Direction(,);
        }
        else{
            return Direction(-1,0);
        }
    }
    
    public String toString(){
        return "D";
    }
} 
