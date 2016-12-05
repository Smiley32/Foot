public class Equipe {
    private int butsMarques;
    private Position but;
    
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
    
    public Position getPositionBut(){
        return this.but;
    }
    
}
