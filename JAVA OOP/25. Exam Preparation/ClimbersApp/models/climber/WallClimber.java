package climbers.models.climber;

import climbers.models.roster.Roster;


public class WallClimber extends BaseClimber {
    private static final double INITIAL_STRENGTH_OF_WALL_CLIMBER = 90;
    private static final int DECREASE_WALL_CLIMBER_STRENGTH = 30;


    private String name;


    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH_OF_WALL_CLIMBER);

        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void climb() {
        double strengthDecrease =  Math.max(0,getStrength() - DECREASE_WALL_CLIMBER_STRENGTH);
        setStrength(strengthDecrease);

    }

    @Override
    public String getName() {
        return name;
    }
}
