import java.util.*;

public class Terrain {
    private int nbLignes;
    private int nbColonnes;
    private int largeurButs;
    private Playable[][] grille;
    private ArrayList<Playable> liste;
    private int tempsJeu;
    private Ballon b;
    
    private static int rand(int min, int max) {
        return (int)(Math.random() * (max - min -1)) + min;
    }
    
    public Terrain() {
        this(11, 21, 5);
    }
    
    public Terrain(int nbL, int nbC) {
        this(nbL, nbC, 5);
    }
    
    public Terrain(int nbL, int nbC, int largeurButs) {
        this.nbLignes = nbL;
        this.nbColonnes = nbC;
        this.largeurButs = largeurButs;
        this.tempsJeu = 0;
        
        // Calcul de la position du ballon
        int posLigne = (int)(this.nbLignes / 2);
        int posColonne = (int)(this.nbColonnes / 2);
        this.b = new Ballon(new Position(posLigne, posColonne));
        
        // Création du terrain
        this.grille = new Playable[nbL][nbC];
        
        // Création des joueurs
        Equipe e1 = new Equipe(new Position(0, this.nbColonnes / 2));
        Equipe e2 = new Equipe(new Position(this.nbLignes + 2, this.nbColonnes / 2));
        
        Defenseur d1e1 = new Defenseur(new Position(1,1), e1);
        Defenseur d2e1 = new Defenseur(new Position(1, nbC - 2), e1);
        Defenseur d1e2 = new Defenseur(new Position(nbL - 2, 1), e2);
        Defenseur d2e2 = new Defenseur(new Position(nbL - 2, nbC - 2), e2);
        
        this.liste = new ArrayList<Playable>();
        this.liste.add(d1e1);
        this.liste.add(d1e2);
        this.liste.add(d2e1);
        this.liste.add(d2e2);
    }
    
    public void update() {
        // Mise a jour de la grille
        for(int i = 0; i < nbLignes; i++) {
            for(int j = 0; j < nbColonnes; j++) {
                grille[i][j] = null;
            }
        }
        
        for(int i = 0; i < liste.size(); i++) {
            grille[liste.get(i).getPosition().getLigne()][liste.get(i).getPosition().getColonne()] = liste.get(i);
        }
        
        // Mise à jour du ballon
        this.b.setPosition(this.b.getPosition().ajout(this.b.getDirection()));
        
        // Pour ne bouger la balle qu'une seule fois
        boolean balleBougee = false;
        // Mise à jour de la liste
        for(int i = 0; i < liste.size(); i++) {
            liste.get(i).setPosition(liste.get(i).getPosition().ajout(liste.get(i).deplacement(b)));
            // Ajouter les verifications de collision
            
            if(liste.get(i).rencontreBalle(b) && !balleBougee) {
                balleBougee = true;
                this.b.setPosition(this.b.getPosition().ajout(liste.get(i).shoote()));
                // Ajouter les tests de collisions
            }
        }
        
    }
    
    public void reinitialiser() {
        for(int i = 0; i < liste.size(); i++) {
            // Position par defaut
            liste.get(i).setPosition();
        }
        
        // Calcul de la position du ballon
        int posLigne = (int)(this.nbLignes / 2);
        int posColonne = (int)(this.nbColonnes / 2);
        this.b.setPosition(new Position(posLigne, posColonne));
    }
    
    public void affichage() {
        // Affichage de la limite nord
        for(int i = 0; i < nbColonnes + 2; i++) {
            System.out.print("#");
        }
        System.out.print("\n");
        
        // Affichage des differentes lignes
        for(int i = 0; i < nbLignes; i++) {
            // Affichage du carac de limite gauche
            System.out.print("#");
            
            // Affichage du terrain
            for(int j = 0; j < nbColonnes; j++) {
                if(grille[i][j] == null) {
                    if(this.b.getPosition().distanceAvec(new Position(i, j)) == 0) {
                        System.out.print("o");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if(this.b.getPosition().distanceAvec(new Position(i, j)) == 0) {
                        System.out.print("o");
                    } else {
                        System.out.print(grille[i][j]);
                    }
                }
            }
            
            // Affichage du carac de limite droite
            System.out.print("#\n");
        }
        
        // Affichage de la limite sud
        for(int i = 0; i < nbColonnes + 2; i++) {
            System.out.print("#");
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args) {
        Terrain jeu = new Terrain();
        jeu.affichage();
        jeu.update();
        jeu.affichage();
        jeu.update();
        jeu.affichage();
    }
}