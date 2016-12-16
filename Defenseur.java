/**
 * Classe Defenseur
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Defenseur extends Joueur {

    private int tempsRepos;

    /**
     * Envoie la nouvelle Direction du ballon, après que le Défenseur l'aie frappé
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
            // Dans ce cas on ne bouge pas le ballon
            return this.t.getBallon().getDirection();
        }
    }

    /**
     * Retourne la direction dans laquelle le défenseur doit se déplacer
     *
     * @return          La nouvelle direction
     */
    public Direction deplacement() {
        tempsRepos--;
        if(pos.distanceAvec(this.t.getBallon().getPosition()) < 4 && tempsRepos <= 0) {
            return pos.seDirigerVers(this.t.getBallon().getPosition());
        } else if (pos.distanceAvec(this.equipe.getPositionBut()) > 4 || tempsRepos > 0) {
            return pos.seDirigerVers(equipe.getPositionBut());
        } else {
            return new Direction(Outils.rand(-1, 1), Outils.rand(-1, 1));
        }
    }

    /**
     * Affichage d'un défenseur
     *
     * @return          Chaine permettant de l'afficher sur le terrain
     */
    public String toString() {
        return Outils.beginColor(equipe.getColor()) + "D" + Outils.endColor();
    }

    /**
     * Création d'un défenseur
     *
     * @param t         Terrain dans lequel le défenseur joue
     * @param positionInitiale Position initiale du défenseur
     * @param equipe    Equipe du défenseur
     */
    public Defenseur(Terrain t, Position positionInitiale, Equipe equipe){
        super(t, positionInitiale, equipe);

        // Initialisation du temps de repos (après une frappe)
        tempsRepos = 0;
    }
}
