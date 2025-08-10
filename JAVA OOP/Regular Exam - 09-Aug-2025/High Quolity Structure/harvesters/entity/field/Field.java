package harvesters.entity.field;

import harvesters.entity.harvester.Harvester;

import java.util.Collection;

public interface Field {

    void reduceCrop();
    Collection<Harvester> getHarvesters();

    String getName();

    int getCrop();



}
