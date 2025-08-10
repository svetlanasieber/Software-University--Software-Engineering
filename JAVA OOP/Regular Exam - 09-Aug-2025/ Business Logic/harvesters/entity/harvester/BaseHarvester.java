package harvesters.entity.harvester;

public abstract class BaseHarvester implements Harvester {
    private String name;
    private int harvest;
    private int strength;

    protected BaseHarvester(String name, int strength) {
        this.setName(name);
        this.strength = strength;
        this.harvest = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Harvester name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public int getHarvest() {
        return this.harvest;
    }

    protected void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    protected void setStrength(int strength) {
        if (strength < 0) {
            this.strength = 0;
        } else {
            this.strength = strength;
        }
    }
}