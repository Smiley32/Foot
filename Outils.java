import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Classe Outils contenant quelques méthodes utilisées dans le programme
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public class Outils {

    /**
     * Attend l'entrée d'un booleen ('faux', 'vrai', 'oui', 'non', 'o', 'n', '0' ou '1')
     *
     * @return      Booléen entré
     */
    public static boolean getBoolean() {
        String reponse;
        boolean ret = false;
        boolean continuer = true;

        while(continuer) {
            reponse = getString();
            reponse = reponse.toLowerCase();

            if(reponse.equals("true") || reponse.equals("vrai") || reponse.equals("oui") || reponse.equals("o") || reponse.equals("1")) {
                continuer = false;
                ret = true;
            } else if (reponse.equals("false") || reponse.equals("faux") || reponse.equals("non") || reponse.equals("n") || reponse.equals("0")) {
                continuer = false;
                ret = false;
            } else {
                ln("Erreur. Il faut entrer un booleen : 'faux', 'vrai', 'oui', 'non', 'o', 'n', '0' ou '1'.");
            }
        }
        return ret;
    }

    /**
     * Attend l'entrée d'un booleen ('faux', 'vrai', 'oui', 'non', 'o', 'n', '0' ou '1') après avoir affiché un message
     *
     * @param texte Message à afficher
     * @return      Booléen entré
     */
    public static boolean getBoolean(String texte) {
        ln(texte);
        return getBoolean();
    }

    /**
     * Attend l'entrée d'une chaîne par l'utilisateur
     *
     * @return      Chaîne entrée par l'utilisateur
     */
    public static String getString() {
        // En cas d'erreur, pas de chaine retournée : null
        String ligneLue = null;

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            ligneLue = br.readLine();
        } catch(IOException e) {
            System.err.println(e);
        }

        return ligneLue;
    }

    /**
     * Attend l'entrée d'une chaîne par l'utilisateur après avoir affiché un message
     *
     * @param texte Texte à afficher
     * @return      Chaîne entrée par l'utilisateur
     */
    public static String getString(String texte) {
        ln(texte);
        return getString();
    }

    /**
     * Attend l'entrée d'un entier par l'utilisateur
     *
     * @return      Entier entré par l'utilisateur
     */
    public static int getInt() {
        int entier = 0;
        boolean continuer = true;

        while(continuer) {
            try {
                entier = Integer.parseInt(getString());
                continuer = false;
            } catch(Exception e) {
                ln("La saisie n'est pas du type souhaité. Recommencez.");
            }
        }
        return entier;
    }

    /**
     * Attend l'entrée d'un entier par l'utilisateur après avoir affiché un message
     *
     * @param texte Texte à afficher
     * @return      Entier entré par l'utilisateur
     */
    public static int getInt(String texte) {
        ln(texte);
        return getInt();
    }

    /**
     * Génère un nombre aléatoire entre un minimum et un maximum (entier)
     *
     * @param min   Borne inférieure
     * @param max   Borne supérieure
     * @return      Entier dans [min,max]
     */
    public static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    /**
     * Efface la console
     */
    public static void effacerConsole() {
        String os = System.getProperty("os.name");

        try {
            if(os.contains("Windows")) {
                // Effacer la console windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Effacer la console mac/linux
                final String ESC = "\033[";
                System.out.print(ESC + "2J");
                System.out.print(ESC + "0;0H");
                System.out.flush();
            }
        } catch(final Exception e) {
            System.out.println("Impossible d'effacer la console");
        }
    }

    /**
     * Met en pause le programme
     *
     * @param ms   Nombre de millisecondes
     */
    public static void pause(int ms) {
        try{
            Thread.sleep(ms);
        } catch(Exception e) {
            System.out.println("Erreur !");
        }
    }

    /**
     * Permet de raccourcir la command System.out.println()
     *
     * @param text    Le texte à afficher
     */
    public static void ln(String text) {
        System.out.println(text);
    }

    /**
     * Permet de raccourcir la command System.out.print()
     *
     * @param text    Le texte à afficher
     */
    public static void a(String text) {
        System.out.print(text);
    }

    /**
     * Création d'une chaine colorant la suite de l'affichage
     *
     * @param color    Le nom de la couleur : (blue, red...)
     * @return          Une chaîne permettant d'écrire le texte qui suit en couleur
     */
    public static String beginColor(String color) {
        String ret;
        switch(color) {
            case "blue":
                ret = (char)27 + "[34;1m";
                break;
            case "red":
                ret = (char)27 + "[31;1m";
                break;
            case "green":
                ret = (char)27 + "[32;1m";
                break;
            default:
                ret = "";
                break;
        }
        return ret;
    }

    /**
     * Création d'une chaine permettant d'arrêter toutes les couleurs définies
     *
     * @return      Une chaîne mettant fin à tout formatage
     */
    public static String endColor() {
        return (char)27 + "[0m";
    }
}
