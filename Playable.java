/**
 * Interface Playable
 * JEANNIN Emile, MOTTET Théo - TP2A
 */
public interface Playable {
    public Direction shoote();
    public Direction deplacement();
    public String toString();
    public boolean rencontreBalle();
    public Position getPosition();
    public void setPosition(Position p);
    public void setPosition();
}
