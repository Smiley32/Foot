/**
 * Classe Milieu
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Milieu extends Joueur {

    private int tempsRepos;

    /**
     * Envoie la nouvelle Direction du ballon, après que le milieu l'aie frappé
     *
     * @return          La nouvelle direction du ballon
     */
    public Direction shoote(){
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
     * Retourne la direction dans laquelle le milieu doit se déplacer
     *
     * @return          La nouvelle direction
     */
    public Direction deplacement() {
        tempsRepos--;
        if(pos.distanceAvec(this.t.getBallon().getPosition()) < 3 && tempsRepos <= 0){
            return pos.seDirigerVers(this.t.getBallon().getPosition());
        } else if (pos.getLigne() == positionInitiale.getLigne()) {
             return new Direction(Outils.rand(-1,1),0);
        } else {
            return pos.seDirigerVers(positionInitiale);
        }
    }

    /**
     * Affichage d'un milieu
     *
     * @return          Chaine permettant de l'afficher sur le terrain
     */
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "M" + Outils.endColor();
    }

    /**
     * Création d'un milieu
     *
     * @param t         Terrain dans lequel le milieu joue
     * @param positionInitiale Position initiale du milieu
     * @param equipe    Equipe du milieu
     */
    public Milieu(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);
        tempsRepos = 0;
    }
}
