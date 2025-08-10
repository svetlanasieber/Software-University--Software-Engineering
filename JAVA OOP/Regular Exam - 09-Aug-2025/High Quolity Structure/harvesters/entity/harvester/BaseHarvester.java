package harvesters.entity.harvester;

import static harvesters.common.ExceptionMessages.HARVESTER_NAME_NULL_OR_EMPTY;

public abstract class BaseHarvester implements Harvester {

    private String name;
    private int harvest;
    private int strength;

    protected BaseHarvester(String name, int strength) {
        this.setName(name);
        this.strength = strength;
        this.harvest = 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(HARVESTER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHarvest() {
        return this.harvest;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setHarvest(int harvest) {
        this.harvest = harvest;
    }
}