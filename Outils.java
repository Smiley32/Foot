public class Outils {

    private static String os = System.getProperty("os.name");

    /**
     * Génère un nombre aléatoire entre un minimum et un maximum (entier)
     *
     * @param int   Borne inférieure
     * @param int   Borne supérieure
     */
    public static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    
    /**
     * Efface la console
     */
    public static void effacerConsole() {
        
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
     * @param int   Nombre de millisecondes
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
     * @param String    Le texte à afficher
     */
    public static void ln(String text) {
        System.out.println(text);
    }
    
    /**
     * Permet de raccourcir la command System.out.print()
     *
     * @param String    Le texte à afficher
     */
    public static void a(String text) {
        System.out.print(text);
    }
    
    /**
     * Création d'une chaine colorant la suite de l'affichage
     *
     * @param String    Le nom de la couleur : (blue, red...)
     */
    public static String beginColor(String color) {
        String ret = "";
        
        if(os.contains("Windows")) {
            ret = "";
        } else {
            // Effacer la console mac/linux
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
        }
        
        return ret;
    }
    
    /**
     * Création d'une chaine permettant d'arrêter toutes les couleurs définies
     */
    public static String endColor() {
        if(os.contains("Windows")) {
            return "";
        } else {
            return (char)27 + "[0m";
        }
    }
}
