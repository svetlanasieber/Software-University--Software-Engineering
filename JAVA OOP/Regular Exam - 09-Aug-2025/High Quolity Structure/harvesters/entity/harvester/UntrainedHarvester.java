package harvesters.entity.harvester;

public class UntrainedHarvester extends BaseHarvester {

    private static final int INITIAL_STRENGTH = 50;

    public UntrainedHarvester(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void harvesting() {
        this.setHarvest(this.getHarvest() + 1);
        int newStrength = this.getStrength() - 10;
        if (newStrength < 0) {
            newStrength = 0;
        }
        this.setStrength(newStrength);
    }
}