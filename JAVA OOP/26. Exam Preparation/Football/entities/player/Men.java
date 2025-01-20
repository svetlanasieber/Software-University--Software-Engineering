package football.entities.player;

public class Men extends BasePlayer {

    private static final double MEN_INITIAL_KILOGRAMS = 85.50;
    private static final int INCREASE_MEN_INITIAL_STRENGTH = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, MEN_INITIAL_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + INCREASE_MEN_INITIAL_STRENGTH);

    }
}
