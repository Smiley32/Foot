public class GoJeu {
    /**
     * Méthode de test
     *
     * @param args      Arguments du programme
     */
    public static void main(String[] args) {
        Terrain jeu = new Terrain();
        int update = 0;
        int tempsJeuMax = 5400;
        while(jeu.getTempsJeu() < tempsJeuMax) {

            Outils.pause(100);

            Outils.effacerConsole();

            jeu.affichage();
            update = jeu.update();
            if(update == 1) {
                Outils.effacerConsole();
                jeu.affichage();
                Outils.pause(1000);
            }
        }
        Outils.ln("Jeu terminé !");
    }
} 
