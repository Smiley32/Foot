/**
 * Classe Attaquant
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Attaquant extends Joueur {

    private int tempsRepos;

    /**
     * Envoie la nouvelle Direction du ballon, après que l'Attaquant l'aie frappé
     *
     * @return          La nouvelle direction du ballon
     */
    public Direction shoote() {
        if(tempsRepos <= 0) {
            tempsRepos = 5;
            if(equipe.getPositionBut().getLigne() < pos.getLigne()) {
                return new Direction(0,1);
            }

            return new Direction(0,-1);
        } else {
            return this.t.getBallon().getDirection();
        }
    }

    /**
     * Retourne la direction dans laquelle l'attaquant doit se déplacer
     *
     * @return          La nouvelle direction
     */
    public Direction deplacement() {
        tempsRepos--;
        if(pos.distanceAvec(this.t.getBallon().getPosition()) < 3 && tempsRepos <= 0){
            return pos.seDirigerVers(this.t.getBallon().getPosition());
        } else if (pos.distanceAvec(this.equipe.getPositionBut()) > 6 || tempsRepos > 0){
            return pos.seDirigerVers(equipe.getPositionBut());
        } else {
            return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
        }
    }

    /**
     * Affichage d'un attaquant
     *
     * @return          Chaine permettant de l'afficher sur le terrain
     */
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "A" + Outils.endColor();
    }

    /**
     * Création d'un attaquant
     *
     * @param t         Terrain dans lequel l'attaquant joue
     * @param positionInitiale Position initiale de l'attaquant
     * @param equipe    Equipe de l'attaquant
     */
    public Attaquant(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);
        this.tempsRepos = 0;
    }
}
