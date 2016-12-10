public class Equipe {
    private int butsMarques;
    private Position but;
    String color;
    
    public int getButsMarques() {
        return butsMarques;
    }
    
    public void ajouterBut(){
        this.butsMarques += 1;
    }
    
    public Equipe(Position but){
        this.butsMarques = 0;
        this.but = but;
    }
    
    public Equipe(Position but, String color) {
        this(but);
        this.color = color;
    }
    
    public Position getPositionBut(){
        return this.but;
    }
    
    public String toString() {
        // Affichage du nombre de buts de l'équipe
        return Outils.beginColor(this.color) + butsMarques + Outils.endColor();
    }
    
    public String getColor() {
        return this.color;
    }
}
