package app.core.commands;

import app.annotations.Inject;
import app.domains.dtos.AirConditionerDto;
import app.domains.entities.airConditioners.PlaneAirConditioner;
import app.services.AirConditionerService;

public class RegisterPlaneAirConditionerCommand extends AbstractCommand {

    @Inject
    private AirConditionerService airConditionerService;

    public RegisterPlaneAirConditionerCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        AirConditionerDto airConditionerDto = new AirConditionerDto();

        String manufacturer = super.getData()[0];
        String model = super.getData()[1];
        Integer volumeCoverage = Integer.parseInt(super.getData()[2]);
        Integer electricityUsed = Integer.parseInt(super.getData()[3]);

        airConditionerDto.setManufacturer(manufacturer);
        airConditionerDto.setModel(model);
        airConditionerDto.setVolumeCovered(volumeCoverage);
        airConditionerDto.setElectricityUsed(electricityUsed);

        this.airConditionerService.persist(airConditionerDto, PlaneAirConditioner.class);

        return String.format("Air Conditioner model %s from %s registered successfully.", model, manufacturer);
    }
}
