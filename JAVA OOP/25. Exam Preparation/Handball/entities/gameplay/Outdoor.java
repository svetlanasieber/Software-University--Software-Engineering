package handball.entities.gameplay;



public class Outdoor extends BaseGameplay {
    private static int OUTDOOR_CAPACITY = 150;

    public Outdoor(String name) {
        super(name, OUTDOOR_CAPACITY);
    }
}
