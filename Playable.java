public interface Playable {
    public Direction shoote();
    public Direction deplacement(Ballon ballon);
    public String toString();
    public boolean rencontreBalle();
    public void marqueBut();
    public Position getPosition();
    public void setPosition(Position p);
    public void setPosition();
}
