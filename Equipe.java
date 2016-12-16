/**
 * Classe Equipe
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Equipe {
    private int butsMarques;
    private Position but;
    String color;

    /**
     * Récupère le nombre de buts marqués par l'équipe
     *
     * return       Nombre de buts
     */
    public int getButsMarques() {
        return butsMarques;
    }

    /**
     * Incrémente le nombre de buts marqués par l'équipe
     */
    public void ajouterBut(){
        this.butsMarques += 1;
    }

    /**
     * Création d'une équipe
     *
     * @param but   Position des buts de l'équipe
     */
    public Equipe(Position but){
        this(but, "unknow");
    }

    /**
     * Création d'une équipe
     *
     * @param but   Position des buts de l'équipe
     * @param color Chaine précisant la couleur de l'équipe
     */
    public Equipe(Position but, String color) {
        this.but = but;
        this.butsMarques = 0;
        this.color = color;
    }

    /**
     * Récupère la position des buts de l'équipe
     *
     * @return      Position des buts
     */
    public Position getPositionBut(){
        return this.but;
    }

    /**
     * Affiche le score en couleur (si possible)
     *
     * @return          Chaine contenant le score
     */
    public String toString() {
        // Affichage du nombre de buts de l'équipe
        return Outils.beginColor(this.color) + butsMarques + Outils.endColor();
    }

    /**
     * Retourne la couleur de l'équipe
     *
     * @return          Chaine contenant la couleur de l'équipe
     */
    public String getColor() {
        return this.color;
    }
}
