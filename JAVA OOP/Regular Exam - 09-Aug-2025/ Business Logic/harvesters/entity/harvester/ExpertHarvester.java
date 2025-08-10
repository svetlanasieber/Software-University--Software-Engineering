package harvesters.entity.harvester;

public class ExpertHarvester extends BaseHarvester {
    private static final int INITIAL_STRENGTH = 150;
    private static final int STRENGTH_DECREASE = 15;
    private static final int HARVEST_INCREASE = 2;

    public ExpertHarvester(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void harvesting() {
        setStrength(getStrength() - STRENGTH_DECREASE);
        setHarvest(getHarvest() + HARVEST_INCREASE);
    }
}