package harvesters.entity.harvesting;

import harvesters.entity.field.CornField;
import harvesters.entity.field.Field;
import harvesters.entity.harvester.Harvester;
import harvesters.entity.harvester.UntrainedHarvester;

public class HarvestingImpl implements Harvesting {

    @Override
    public void startHarvesting(Field field) {
        if (field.getCrop() <= 0) {
            return;
        }

        for (Harvester harvester : field.getHarvesters()) {
            if (field instanceof CornField && harvester instanceof UntrainedHarvester) {
                continue;
            }

            while (harvester.getStrength() > 0 && field.getCrop() > 0) {
                harvester.harvesting();
                field.reduceCrop();
            }
        }
    }
}