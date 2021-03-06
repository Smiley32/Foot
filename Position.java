/**
 * Classe Position
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
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
     * @param l   La ligne
     * @param c   La colonne
     */
    public Position(int l, int c) {
        this.ligne = l;
        this.colonne = c;
    }

    /**
     * Calcule la distance entre lui-même et une autre Position
     *
     * @param p     L'autre Position
     * @return      La distance entre les deux positions (réelle)
     */
    public double distanceAvec(Position p) {
        return Math.sqrt((p.ligne - this.ligne) * (p.ligne - this.ligne) + (p.colonne - this.colonne) * (p.colonne - this.colonne));
    }

    /**
     * Récupère la ligne
     *
     * @return      Ligne
     */
    public int getLigne(){
        return this.ligne;
    }

    /**
     * Récupère la colonne
     *
     * @return      Colonne
     */
    public int getColonne(){
        return this.colonne;
    }

    /**
     * Incremente la Position dans la direction voulue
     *
     * @param Direction     La Direction dans laquelle incrémenter
     * @return Position     Nouvelle Position créée
     */
    public Position ajout(Direction d) {
        return new Position(this.ligne + d.getY(), this.colonne + d.getX());
    }

    /**
     * Renvoie la direction de la position en paramètre
     *
     * @param p     Position du point vers lequel se diriger
     * @return      Direction du point
     */
    public Direction seDirigerVers(Position p){
        int dirX, dirY;

        if(this.getColonne() < p.getColonne()) {
            dirX = 1;
        } else if(this.getColonne() == p.getColonne()) {
            dirX = 0;
        } else {
            dirX = -1;
        }

        if(this.getLigne() < p.getLigne()) {
            dirY = 1;
        } else if(this.getLigne() == p.getLigne()) {
            dirY = 0;
        } else {
            dirY = -1;
        }

        return new Direction(dirX, dirY);
    }
}
