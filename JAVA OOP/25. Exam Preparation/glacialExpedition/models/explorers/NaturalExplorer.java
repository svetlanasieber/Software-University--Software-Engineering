package glacialExpedition.models.explorers;

public class NaturalExplorer extends  BaseExplorer{
    private static final double NATURAL_EXPLORER_INITIAL_ENERGY = 60.0;
    private static final double NATURAL_EXPLORER_INITIAL_ENERGY_DECREASE = 7.0;
    public NaturalExplorer(String name) {
        super(name, NATURAL_EXPLORER_INITIAL_ENERGY);
    }

    @Override
    public void search() {

        super.setEnergy(Math.max(super.getEnergy() -NATURAL_EXPLORER_INITIAL_ENERGY_DECREASE ,0));
    }
}
