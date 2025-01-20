package climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final double ROCK_CLIMBER_INITIAL_STRENGTH = 120;
    private static final int DECREASE_ROCK_CLIMBER_UNITS = 60;

    private String name;
    public RockClimber(String name) {
        super(name, ROCK_CLIMBER_INITIAL_STRENGTH);

    }

    @Override
    public void climb() {
        double strengthDecrease =  Math.max(0,getStrength() - DECREASE_ROCK_CLIMBER_UNITS);
        setStrength(strengthDecrease);

    }


}
