package harvesters.entity.field;

import harvesters.entity.harvester.Harvester;

import java.util.ArrayList;
import java.util.Collection;

import static harvesters.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int crop;
    private Collection<Harvester> harvesters;

    protected BaseField(String name, int crop) {
        this.setName(name);
        this.crop = crop;
        this.harvesters = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCrop() {
        return this.crop;
    }
    
    protected void setCrop(int crop) {
        this.crop = crop;
    }

    @Override
    public Collection<Harvester> getHarvesters() {
        return this.harvesters;
    }
}