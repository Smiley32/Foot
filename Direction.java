public class Direction {
    private int x;
    private int y;
    
    public Direction() {
        this(0,0);
    }
    
    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
