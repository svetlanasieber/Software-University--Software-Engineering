package harvesters.entity.harvester;

public class ProficientHarvester extends BaseHarvester {
    private static final int INITIAL_STRENGTH = 100;
    private static final int STRENGTH_DECREASE = 10;
    private static final int HARVEST_INCREASE = 1;

    public ProficientHarvester(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void harvesting() {
        setStrength(getStrength() - STRENGTH_DECREASE);
        setHarvest(getHarvest() + HARVEST_INCREASE);
    }
}