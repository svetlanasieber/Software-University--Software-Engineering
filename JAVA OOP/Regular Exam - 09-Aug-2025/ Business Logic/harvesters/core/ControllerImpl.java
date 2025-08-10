package harvesters.core;

import harvesters.entity.field.*;
import harvesters.entity.harvesting.Harvesting;
import harvesters.entity.harvesting.HarvestingImpl;
import harvesters.repository.FieldRepository;
import harvesters.repository.Repository;
import harvesters.entity.harvester.ExpertHarvester;
import harvesters.entity.harvester.Harvester;
import harvesters.entity.harvester.ProficientHarvester;
import harvesters.entity.harvester.UntrainedHarvester;

public class ControllerImpl implements Controller {
    private Repository<Field> fieldRepository;
    private Harvesting harvesting;

    public ControllerImpl() {
        this.fieldRepository = new FieldRepository();
        this.harvesting = new HarvestingImpl();
    }

    @Override
    public String addField(String fieldType, String fieldName, int crops) {
        if (crops < 0) {
            throw new IllegalArgumentException("Field crops cannot be a negative number.");
        }
        if (fieldRepository.byName(fieldName) != null) {
            throw new IllegalArgumentException("This field already exists in repository.");
        }

        Field field;
        switch (fieldType) {
            case "WheatField":
                field = new WheatField(fieldName, crops);
                break;
            case "RiceField":
                field = new RiceField(fieldName, crops);
                break;
            case "CornField":
                field = new CornField(fieldName, crops);
                break;
            default:
                throw new IllegalArgumentException("Invalid field type.");
        }

        fieldRepository.add(field);
        return String.format("Field %s %s added.", fieldName, fieldType);
    }

    @Override
    public String addHarvester(String fieldName, String harvesterType, String harvesterName) {
        Field field = fieldRepository.byName(fieldName);
        if (field == null) {
            throw new NullPointerException(fieldName + " does not exist in the field repository.");
        }

        if (field.getHarvesters().stream().anyMatch(h -> h.getName().equals(harvesterName))) {
            throw new IllegalArgumentException(String.format("Harvester with name %s already exist in this field.", harvesterName));
        }

        Harvester harvester;
        switch (harvesterType) {
            case "UntrainedHarvester":
                harvester = new UntrainedHarvester(harvesterName);
                break;
            case "ProficientHarvester":
                harvester = new ProficientHarvester(harvesterName);
                break;
            case "ExpertHarvester":
                harvester = new ExpertHarvester(harvesterName);
                break;
            default:
                throw new IllegalArgumentException("Invalid harvester.");
        }

        field.getHarvesters().add(harvester);
        return String.format("%s %s added.", harvesterType, harvesterName);
    }

    @Override
    public String goHarvesting(String fieldName) {
        Field field = fieldRepository.byName(fieldName);
        if (field == null) {
            throw new NullPointerException(String.format("%s does not exist in the field repository.", fieldName));
        }

        harvesting.startHarvesting(field);

        String fieldType = field.getClass().getSimpleName();
        if (field.getCrop() > 0) {
            return String.format("There was harvesters at %s %s. Remaining crops: %d", fieldName, fieldType, field.getCrop());
        } else {
            return String.format("Harvesting more crops in %s %s is not possible.", fieldName, fieldType);
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fieldRepository.getCollection()) {
            boolean hasHarvestersWithHarvest = field.getHarvesters().stream().anyMatch(h -> h.getHarvest() > 0);
            if (hasHarvestersWithHarvest) {
                sb.append(String.format("Harvester harvesting on %s %s:", field.getName(), field.getClass().getSimpleName())).append(System.lineSeparator());
                for (Harvester harvester : field.getHarvesters()) {
                    if (harvester.getHarvest() > 0) {
                        sb.append(String.format("Name: %s", harvester.getName())).append(System.lineSeparator());
                        sb.append(String.format("Strength left: %d", harvester.getStrength())).append(System.lineSeparator());
                        sb.append(String.format("Harvested crops: %d", harvester.getHarvest())).append(System.lineSeparator());
                    }
                }
            }
        }
        return sb.toString().trim();
    }
}
