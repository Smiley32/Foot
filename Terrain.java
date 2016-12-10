import java.util.*;

public class Terrain {
    private int nbLignes;
    private int nbColonnes;
    private int largeurButs;
    private Playable[][] grille;
    private ArrayList<Playable> liste;
    private int tempsJeu;
    private Ballon b;
    
    // Equipes sur le terrain
    private Equipe e1;
    private Equipe e2;
    
    /**
     * Création d'un terrain par défaut
     */
    public Terrain() {
        this(11, 21, 5);
    }
    
    /**
     * Création d'un terrain en précisant sa taille
     *
     * @param int   Nombre de lignes
     * @param int   Nombre de colonnes
     */
    public Terrain(int nbL, int nbC) {
        this(nbL, nbC, 5);
    }
    
    /**
     * Création d'un terrain en précisant sa taille ainsi que la largeur des buts
     *
     * @param int   Nombre de lignes
     * @param int   Nombre de colonnes
     * @param int   Largeur des buts
     */
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
        
        // Création des équipes
        e1 = new Equipe(new Position(0, this.nbColonnes / 2), "red");
        e2 = new Equipe(new Position(this.nbLignes + 2, this.nbColonnes / 2), "blue");
        
        // Création des joueurs
        Defenseur d1e1 = new Defenseur(new Position(1,1), e1);
        Defenseur d2e1 = new Defenseur(new Position(1, nbC - 2), e1);
        Defenseur d1e2 = new Defenseur(new Position(nbL - 2, 1), e2);
        Defenseur d2e2 = new Defenseur(new Position(nbL - 2, nbC - 2), e2);
        Troll t1 = new Troll(new Position(2, 2));
        Troll t2 = new Troll(new Position(3, 2));
        
        this.liste = new ArrayList<Playable>();
        this.liste.add(d1e1);
        this.liste.add(d1e2);
        this.liste.add(d2e1);
        this.liste.add(d2e2);
        this.liste.add(new Defenseur(new Position(1,1), e1));
        this.liste.add(new Defenseur(new Position(1, nbC - 2), e1));
        this.liste.add(new Defenseur(new Position(nbL - 2, 1), e2));
        this.liste.add(new Defenseur(new Position(nbL - 2, nbC - 2), e2));
        this.liste.add(t1);
        this.liste.add(t2);
    }
    
    /**
     * Met à jour le terrain et ses éléments (joueurs, balle, etc.)
     *
     * @return int      Retourne 1 si il y a but
     */
    public int update() {
        // Incrémentation du temps de jeu
        tempsJeu++;
    
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
        Position newPosBallon = this.b.getPosition().ajout(this.b.getDirection());
        
        
        if(newPosBallon.getLigne() < 0 || newPosBallon.getLigne() >= nbLignes) {
            this.b.setDirection(new Direction(this.b.getDirection().getX(), -this.b.getDirection().getY()));
        } else if(newPosBallon.getColonne() < 0 || newPosBallon.getColonne() >= nbColonnes) {
            this.b.setDirection(new Direction(-this.b.getDirection().getX(), this.b.getDirection().getY()));
        }
        
        this.b.setPosition(this.b.getPosition().ajout(this.b.getDirection()));
        
        // Verification de but
        int positionBut = (nbColonnes - largeurButs) / 2;
        // Les buts sont donc sur la ligne -1 et nbLignes, de positionBut à positionBut+largeurButs
        
        boolean but = false;
        if(newPosBallon.getColonne() >= positionBut && newPosBallon.getColonne() < positionBut + largeurButs) {
            // Il y a but
            if(newPosBallon.getLigne() == -1) {
                this.e2.ajouterBut();
                but = true;
                
                // Action spéciale potentielle en cas de but
                this.b.getDerniereFrappe().marqueBut();
                
                reinitialiser();
            } else if(newPosBallon.getLigne() == nbLignes) {
                this.e1.ajouterBut();
                but = true;
                
                // Action spéciale potentielle en cas de but
                this.b.getDerniereFrappe().marqueBut();
                
                reinitialiser();
            }
            
            
        }
        
        // Si il n'y a pas but on fait bouger les personnages
        if(!but) {
            // Pour ne bouger la balle qu'une seule fois
            boolean balleBougee = false;
            // Mise à jour de la liste
            for(int i = 0; i < liste.size(); i++) {
                // Si la position est correcte
                
                Position newPos = liste.get(i).getPosition().ajout(liste.get(i).deplacement());
                if(newPos.getColonne() >= 0 && newPos.getColonne() < nbColonnes && newPos.getLigne() >= 0 && newPos.getLigne() < nbLignes) {
                    liste.get(i).setPosition(newPos);
                    
                } else {
                    // Si on est dans un mur, on ne bouge pas
                }
                
                // Ajouter les verifications de collision
                
                if(liste.get(i).rencontreBalle(b) && !balleBougee) {
                    balleBougee = true;
                    Direction dirShoote = liste.get(i).shoote();
                    this.b.setDirection(dirShoote);
                    this.b.setDerniereFrappe(liste.get(i));
                    // this.b.setPosition(this.b.getPosition().ajout(dirShoote));
                    
                    // Ajouter les tests de collisions
                }
            }
        }
        
        return but ? 1 : 0;
    }
    
    /**
     * Récupère le temps de jeu
     *
     * @return int      Temps de jeu (nombre de tours)
     */
    public int getTempsJeu() {
        return this.tempsJeu;
    }
    
    /**
     * Remet les joueurs à leur place de départ
     */
    public void reinitialiser() {
        for(int i = 0; i < liste.size(); i++) {
            // Position par defaut
            liste.get(i).setPosition();
        }
        
        // Calcul de la position du ballon
        int posLigne = (int)(this.nbLignes / 2);
        int posColonne = (int)(this.nbColonnes / 2);
        this.b.setPosition(new Position(posLigne, posColonne));
        this.b.setDirection(new Direction(0, 0));
    }
    
    /**
     * Génère l'affichage du terrain et de son contenu
     */
    public void affichage() {
        // Affichage de la limite nord
        for(int i = 0; i < nbColonnes + 2; i++) {
            if(i < (nbColonnes - largeurButs) / 2 || i >= (nbColonnes - largeurButs) / 2 + largeurButs) {
                Outils.a("#");
            } else {
                Outils.a(" ");
            }
        }
        Outils.a("\n");
        
        // Affichage des differentes lignes
        for(int i = 0; i < nbLignes; i++) {
            // Affichage du carac de limite gauche
            Outils.a("#");
            
            // Affichage du terrain
            for(int j = 0; j < nbColonnes; j++) {
                if(grille[i][j] == null) {
                    if(this.b.getPosition().distanceAvec(new Position(i, j)) == 0) {
                        Outils.a("o");
                    } else {
                        Outils.a(" ");
                    }
                } else {
                    if(this.b.getPosition().distanceAvec(new Position(i, j)) == 0) {
                        Outils.a("o");
                    } else {
                        Outils.a(grille[i][j].toString());
                    }
                }
            }
            
            // Affichage du carac de limite droite
            Outils.a("#\n");
        }
        
        // Affichage de la limite sud
        for(int i = 0; i < nbColonnes + 2; i++) {
            if(i < (nbColonnes - largeurButs) / 2 || i >= (nbColonnes - largeurButs) / 2 + largeurButs) {
                Outils.a("#");
            } else {
                Outils.a(" ");
            }
        }
        Outils.a("\n");
        
        // Affichage du score
        Outils.ln("Score : [" + e1 + " - " + e2 + "]");
    }
    
    
    
    public static void main(String[] args) {
        Terrain jeu = new Terrain();
        int update = 0;
        int tempsJeuMax = 180;
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
