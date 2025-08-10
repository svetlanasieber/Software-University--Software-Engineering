package harvesters.entity.field;

import harvesters.entity.harvester.Harvester;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Field {
    private String name;
    private int crop;
    private Collection<Harvester> harvesters;

    protected Field(String name, int crop) {
        this.setName(name);
        this.crop = crop;
        this.harvesters = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Field name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getCrop() {
        return this.crop;
    }
    
    protected void setCrop(int crop) {
        this.crop = crop;
    }

    public Collection<Harvester> getHarvesters() {
        return this.harvesters;
    }
    
    public abstract void reduceCrop();
}
