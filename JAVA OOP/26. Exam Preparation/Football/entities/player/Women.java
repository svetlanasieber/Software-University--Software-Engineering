package football.entities.player;

public class Women extends BasePlayer{
    private static final double WOMAN_INITIAL_KILOGRAMS = 60.00;
    private static final int INCREASE_WOMAN_INITIAL_STRENGTH = 115;
    public Women(String name, String nationality, int strength) {
        super(name, nationality,WOMAN_INITIAL_KILOGRAMS , strength);
    }


    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + INCREASE_WOMAN_INITIAL_STRENGTH);

    }
}
