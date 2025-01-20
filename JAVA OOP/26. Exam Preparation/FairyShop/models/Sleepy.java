package fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int SLEEPY_INITIAL_ENERGY = 50;
    private static final int SLEEPY_DECREASE_ENERGY = 5;

    public Sleepy(String name) {
        super(name, SLEEPY_INITIAL_ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(this.getEnergy() - SLEEPY_INITIAL_ENERGY);
    }
}
