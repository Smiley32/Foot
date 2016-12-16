/**
 * Classe abstraite Joueur
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public abstract class Joueur implements Playable {

    protected Position positionInitiale;
    // Position actuelle du joueur
    protected Position pos;
    protected Equipe equipe;
    protected Terrain t;

    /**
     * Création d'un joueur
     *
     * @param t         Terrain dans lequel le joueur joue
     * @param positionInitiale Position initiale du joueur
     * @param equipe    Equipe du joueur
     */
    public Joueur(Terrain t, Position positionInitiale, Equipe equipe){
        this.positionInitiale = positionInitiale;
        this.pos = positionInitiale;
        this.equipe = equipe;
        this.t = t;
    }

    /**
     * Récupère la position du joueur
     *
     * @return      Position du joueur
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Modifie la position du joueur
     *
     * @param p         Nouvelle position du joueur
     */
    public void setPosition(Position p) {
        this.pos = p;
    }

    /**
     * Signale si le joueur rencontre la balle
     *
     * @return      Booléen Vrai si le joueur rencontre la balle
     */
    public boolean rencontreBalle(){
        return pos.distanceAvec(this.t.getBallon().getPosition()) == 0;
    }

    /**
     * Modifie la position du joueur pour le remettre à sa position initiale
     */
    public void setPosition() {
        this.pos = this.positionInitiale;
    }

    /**
     * Comportement par défaut de l'action de shooter : aléatoire
     *
     * @return      Nouvelle direction de la balle
     */
    public Direction shoote(){
        return new Direction(Outils.rand(0,2)-1, Outils.rand(0,2)-1);
    }

    /**
     * Comportement par défaut de l'action de déplacement : aléatoire
     *
     * @return      Nouvelle direction du joueur
     */
    public Direction deplacement(){
        return new Direction(Outils.rand(0,2)-1, Outils.rand(0,2)-1);
    }
}
