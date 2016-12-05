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
}