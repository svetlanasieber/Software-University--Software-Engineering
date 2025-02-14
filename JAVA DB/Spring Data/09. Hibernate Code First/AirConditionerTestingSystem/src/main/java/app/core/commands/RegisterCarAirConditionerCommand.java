package app.core.commands;

import app.annotations.Inject;
import app.domains.dtos.AirConditionerDto;
import app.domains.entities.airConditioners.CarAirConditioner;
import app.services.AirConditionerService;

public class RegisterCarAirConditionerCommand extends AbstractCommand {

    @Inject
    private AirConditionerService airConditionerService;

    public RegisterCarAirConditionerCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        AirConditionerDto airConditionerDto = new AirConditionerDto();

        String manufacturer = super.getData()[0];
        String model = super.getData()[1];
        Integer volumeCoverage = Integer.parseInt(super.getData()[2]);

        airConditionerDto.setManufacturer(manufacturer);
        airConditionerDto.setModel(model);
        airConditionerDto.setVolumeCovered(volumeCoverage);

        this.airConditionerService.persist(airConditionerDto, CarAirConditioner.class);

        return String.format("Air Conditioner model %s from %s registered successfully.", model, manufacturer);
    }
}
