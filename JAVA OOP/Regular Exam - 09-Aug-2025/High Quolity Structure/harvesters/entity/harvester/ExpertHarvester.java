package harvesters.entity.harvester;

public class ExpertHarvester extends BaseHarvester {
    private static final int INITIAL_STRENGTH = 150;

    public ExpertHarvester(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void harvesting() {
        this.setHarvest(this.getHarvest() + 2);
        int newStrength = this.getStrength() - 15;
        if (newStrength < 0) {
            newStrength = 0;
        }
        this.setStrength(newStrength);
    }
}