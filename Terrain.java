import java.util.*;

/**
 * Classe Terrain qui est la classe principale coordonnant tout le jeu
 */
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
     * Retourne le Ballon du jeu
     *
     * @return      Le ballon
     */
    public Ballon getBallon() {
        return this.b;
    }

    /**
     * Création d'un en demandant au joueur les informations
     */
    public Terrain() {
        // Entrée d'une taille par l'utilisateur
        Outils.ln("Création du terrain :");

        if(Outils.getBoolean("Créer un terrain par défaut ? (o/n)")) {
            // Création d'un terrain par défaut
            this.nbLignes = 21;
            this.nbColonnes = 21;
            this.largeurButs = 7;
            this.tempsJeu = 0;

            // Calcul de la position du ballon
            int posLigne = (int)(this.nbLignes / 2);
            int posColonne = (int)(this.nbColonnes / 2);
            this.b = new Ballon(new Position(posLigne, posColonne));

            // Création du terrain
            this.grille = new Playable[this.nbLignes][this.nbColonnes];

            // Création des équipes
            e1 = new Equipe(new Position(0, this.nbColonnes / 2), "red");
            e2 = new Equipe(new Position(this.nbLignes - 1, this.nbColonnes / 2), "blue");

            // Création des joueurs

            this.liste = new ArrayList<Playable>();
            this.liste.add(new Attaquant(this, new Position(10, 1), e1));
            this.liste.add(new Milieu(this, new Position(3, this.nbColonnes - 2), e1));
            this.liste.add(new Defenseur(this, new Position(1,3), e1));

            this.liste.add(new Attaquant(this, new Position(10, 5), e1));
            this.liste.add(new Milieu(this, new Position(3, this.nbColonnes - 2), e1));
            this.liste.add(new Defenseur(this, new Position(1,7), e1));

            this.liste.add(new Attaquant(this, new Position(this.nbLignes - 10, 1), e2));
            this.liste.add(new Milieu(this, new Position(this.nbLignes - 5, this.nbColonnes - 2), e2));
            this.liste.add(new Defenseur(this, new Position(this.nbLignes - 2, 3), e2));

            this.liste.add(new Attaquant(this, new Position(this.nbLignes - 10, 5), e2));
            this.liste.add(new Milieu(this, new Position(this.nbLignes - 5, this.nbColonnes - 2), e2));
            this.liste.add(new Defenseur(this, new Position(this.nbLignes - 2, 7), e2));

            this.liste.add(new Troll(this, new Position(2, 2)));
            this.liste.add(new Troll(this, new Position(3, 2)));
            this.liste.add(new Troll(this, new Position(2, 3)));
            this.liste.add(new Troll(this, new Position(4, 4)));
        } else {
            int nbColonnes;
            // On entre un nombre impair de colonnes
            do {
                nbColonnes = Outils.getInt("Entrer le nombre de colonnes (impair) :");

                if(nbColonnes < 5) {
                    Outils.ln("Non, c'est trop petit...");
                }

                // Nombre pair
                if(nbColonnes % 2 == 0) {
                    Outils.ln("Le nombre doit être impair");
                }
            } while(nbColonnes % 2 == 0 || nbColonnes < 5);


            int nbLignes;
            // On entre un nombre de lignes impair
            do {
                nbLignes = Outils.getInt("Entrer le nombre de lignes (impair) :");

                if(nbLignes < 5) {
                    Outils.ln("Non, c'est trop petit...");
                }

                // Nombre pair
                if(nbLignes % 2 == 0) {
                    Outils.ln("Le nombre doit être impair");
                }
            } while(nbLignes % 2 == 0 || nbLignes < 5);


            int largeurButs;
            // On entre la largeur des buts (impair)
            do {
                largeurButs = Outils.getInt("Entrer la largeur des buts (impair) :");

                if(largeurButs > nbColonnes - 2) {
                    Outils.ln("Non, c'est trop grand !");
                }

                if(largeurButs < 1) {
                    Outils.ln("Non, c'est trop petit...");
                }

                // Nombre pair
                if(largeurButs % 2 == 0) {
                    Outils.ln("Le nombre doit être impair");
                }
            } while(largeurButs % 2 == 0 || largeurButs < 1 || largeurButs > nbColonnes - 2);

            this.nbLignes = nbLignes;
            this.nbColonnes = nbColonnes;
            this.largeurButs = largeurButs;

            // Initialisation du temps de jeu
            this.tempsJeu = 0;

            // Calcul de la position du ballon
            int posLigne = (int)(this.nbLignes / 2);
            int posColonne = (int)(this.nbColonnes / 2);
            this.b = new Ballon(new Position(posLigne, posColonne));

            // Création du terrain
            this.grille = new Playable[this.nbLignes][this.nbColonnes];

            // Création des équipes
            e1 = new Equipe(new Position(0, this.nbColonnes / 2), "red");
            e2 = new Equipe(new Position(this.nbLignes - 1, this.nbColonnes / 2), "blue");

            // Création de la liste
            this.liste = new ArrayList<Playable>();

            // Création des joueurs
            int choix;
            int x;
            int y;
            int equipe = 0;
            while(Outils.getBoolean("Ajouter un joueur ?")) {

                do {
                    choix = Outils.getInt("Choisir un type :\n1. Attaquant\n2. Defenseur\n3. Milieu\n4. Troll");

                    if(choix <= 0 || choix > 4) {
                        Outils.ln("Non...");
                    }
                } while(choix <= 0 || choix > 4);

                Outils.ln("Entrer la position du joueur :");
                // Ligne
                do {
                    x = Outils.getInt("Entrer la ligne (-1 pour aléatoire) :");

                    if(x == -1) {
                        x = Outils.rand(0, this.nbLignes - 1);
                    }

                    if(x < 0 || x >= this.nbLignes) {
                        Outils.ln("Ligne incorrecte.");
                    }
                } while(x < 0 || x >= this.nbLignes);

                // Colonne
                do {
                    y = Outils.getInt("Entrer la colonne (-1 pour aléatoire) :");

                    if(y == -1) {
                        y = Outils.rand(0, this.nbColonnes - 1);
                    }

                    if(y < 0 || y >= this.nbColonnes) {
                        Outils.ln("Colonne incorrecte.");
                    }
                } while(y < 0 || y >= this.nbColonnes);

                // Si c'est pas un troll, choix de l'équipe
                if(choix != 4) {
                    do {
                        equipe = Outils.getInt("Equipe : 1. ou 2. :");

                        if(equipe != 1 && equipe != 2) {
                            Outils.ln("Il y a deux équipes.");
                        }
                    } while(equipe != 1 && equipe != 2);
                }

                // Ajout du joueur à la liste
                switch(choix) {
                    case 1:
                        // Attaquant
                        this.liste.add(new Attaquant(this, new Position(x, y), equipe == 1 ? e1 : e2));
                        break;
                    case 2:
                        // Defenseur
                        this.liste.add(new Defenseur(this, new Position(x, y), equipe == 1 ? e1 : e2));
                        break;
                    case 3:
                        // Milieu
                        this.liste.add(new Milieu(this, new Position(x, y), equipe == 1 ? e1 : e2));
                        break;
                    case 4:
                        // Troll
                        this.liste.add(new Troll(this, new Position(x, y)));
                        break;
                    default:
                        // Autre
                        this.liste.add(new Troll(this, new Position(x, y)));
                        break;
                }
            }
        }
    }

    /**
     * Met à jour le terrain et ses éléments (joueurs, balle, etc.)
     *
     * @return      Retourne 1 si il y a but
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
            if(grille[liste.get(i).getPosition().getLigne()][liste.get(i).getPosition().getColonne()] == null)
                grille[liste.get(i).getPosition().getLigne()][liste.get(i).getPosition().getColonne()] = liste.get(i);
        }

        // Mise à jour du ballon
        Position newPosBallon = this.b.getPosition().ajout(this.b.getDirection());


        // Si la balle sort, on la fait rebondir
        if(newPosBallon.getLigne() < 0 || newPosBallon.getLigne() >= nbLignes) {
            this.b.setDirection(new Direction(this.b.getDirection().getX(), -this.b.getDirection().getY()));
        } else if(newPosBallon.getColonne() < 0 || newPosBallon.getColonne() >= nbColonnes) {
            this.b.setDirection(new Direction(-this.b.getDirection().getX(), this.b.getDirection().getY()));
        }

        /*
        // Si la balle sort du terrain, elle est en touche et est renvoyée aléatoirement dans le terrain
        if(newPosBallon.getLigne() < 0 || newPosBallon.getLigne() >= nbLignes || newPosBallon.getColonne() < 0 || newPosBallon.getColonne() >= nbColonnes) {
            this.b.setPosition(new Position(Outils.rand(0, nbLignes - 1), Outils.rand(0, nbColonnes)));
            this.b.setDirection(new Direction(Outils.rand(-1,1), Outils.rand(-1,1)));
        }*/

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

                reinitialiser();
            } else if(newPosBallon.getLigne() == nbLignes) {
                this.e1.ajouterBut();
                but = true;

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

                if(liste.get(i).rencontreBalle() && !balleBougee) {
                    balleBougee = true;
                    Direction dirShoote = liste.get(i).shoote();
                    this.b.setDirection(dirShoote);
                }
            }
        }

        return but ? 1 : 0;
    }

    /**
     * Récupère le temps de jeu
     *
     * @return      Temps de jeu (nombre de tours)
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
        Outils.a("#");
        for(int i = 0; i < nbColonnes; i++) {
            if(i < (nbColonnes - largeurButs) / 2 || i >= (nbColonnes - largeurButs) / 2 + largeurButs) {
                Outils.a("#");
            } else {
                Outils.a(" ");
            }
        }
        Outils.a("#");
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
        Outils.a("#");
        for(int i = 0; i < nbColonnes; i++) {
            if(i < (nbColonnes - largeurButs) / 2 || i >= (nbColonnes - largeurButs) / 2 + largeurButs) {
                Outils.a("#");
            } else {
                Outils.a(" ");
            }
        }
        Outils.a("#\n");

        // Affichage du score
        Outils.ln("Score : [" + e1 + " - " + e2 + "]");

        // Affichage du temps
        Outils.ln("Temps : " + tempsJeu/60 + ":" + tempsJeu%60);
    }
}
