public class Position {
    private int ligne;
    private int colonne;
    
    public Position() {
        this.ligne = 0;
        this.colonne = 0;
    }
    
    public Position(int l, int c) {
        this.ligne = l;
        this.colonne = c;
    }
    
    public double distanceAvec(Position p) {
        return Math.sqrt((p.ligne - this.ligne) * (p.ligne - this.ligne) + (p.colonne - this.colonne) * (p.colonne - this.colonne));
        // 
    }
}