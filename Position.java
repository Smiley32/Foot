public class Position {
    private int ligne;
    private int colonne;
    
    /**
     * Création d'une Position par défaut
     */
    public Position() {
        this.ligne = 0;
        this.colonne = 0;
    }
    
    /**
     * Création d'une Position
     *
     * @param int   La ligne
     * @param int   La colonne
     */
    public Position(int l, int c) {
        this.ligne = l;
        this.colonne = c;
    }
    
    /**
     * Calcule la distance entre lui-même et une autre Position
     *
     * @param Position  L'autre Position
     */
    public double distanceAvec(Position p) {
        return Math.sqrt((p.ligne - this.ligne) * (p.ligne - this.ligne) + (p.colonne - this.colonne) * (p.colonne - this.colonne));
    }
    
    public int getLigne(){
        return this.ligne;
    }
    
    public int getColonne(){
        return this.colonne;
    }
    
    public Position ajout(Direction d) {
        return new Position(this.ligne + d.getY(), this.colonne + d.getX());
    }
    
    public Direction seDirigerVers(Position p){
        if (ligne == p.ligne && colonne == p.colonne){
            return new Direction(0,0);
        }
        else if(ligne == p.ligne && colonne < p.colonne){
            return new Direction(1,0);
        }
        else if(ligne == p.ligne && colonne > p.colonne){
            return new Direction(-1,0);
        }
        else if(ligne < p.ligne && colonne == p.colonne){
            return new Direction(0,1);
        }
        else if(ligne > p.ligne && colonne == p.colonne){
            return new Direction(0,-1);
        }
        else if(ligne > p.ligne && colonne > p.colonne){
            return new Direction(-1,1);
        }
        else if(ligne < p.ligne && colonne < p.colonne){
            return new Direction(1,-1);
        }
        else if(ligne < p.ligne && colonne > p.colonne){
            return new Direction(-1,-1);
        }
        else /*(ligne > p.ligne && colonne < p.colonne)*/{
            return new Direction(1,1);
        }
        
    }
}
