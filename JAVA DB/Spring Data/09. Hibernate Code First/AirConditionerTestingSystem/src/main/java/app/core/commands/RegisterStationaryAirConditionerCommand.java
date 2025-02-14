package app.core.commands;

import app.annotations.Inject;
import app.domains.dtos.AirConditionerDto;
import app.domains.entities.airConditioners.StationaryAirConditioner;
import app.domains.enums.EfficiencyRating;
import app.services.AirConditionerService;

public class RegisterStationaryAirConditionerCommand extends AbstractCommand {

    @Inject
    private AirConditionerService airConditionerService;

    public RegisterStationaryAirConditionerCommand(String[] date) {
        super(date);
    }

    @Override
    public String execute() {
        AirConditionerDto airConditionerDto = new AirConditionerDto();

        String[] tokens = super.getData();
        airConditionerDto.setManufacturer(tokens[0]);
        airConditionerDto.setModel(tokens[1]);
        airConditionerDto.setRequiredEfficiencyRating(tokens[2]);
        airConditionerDto.setPowerUsage(Integer.parseInt(tokens[3]));
        airConditionerDto.setRealEfficiencyRating(this.calculateEfficiencyRating(airConditionerDto.getPowerUsage()));

        this.airConditionerService.persist(airConditionerDto, StationaryAirConditioner.class);

        return String.format("Air Conditioner model %s from %s registered successfully.",
                airConditionerDto.getModel(), airConditionerDto.getManufacturer());
    }

    private String calculateEfficiencyRating(Integer powerUsage) {
        if (powerUsage > 2000) {
            return EfficiencyRating.E.toString();
        } else if (powerUsage >= 1501 && powerUsage <= 2000) {
            return EfficiencyRating.D.toString();
        } else if (powerUsage >= 1251 && powerUsage <= 1500) {
            return EfficiencyRating.C.toString();
        } else if (powerUsage >= 1000 && powerUsage <= 1250) {
            return EfficiencyRating.B.toString();
        } else {
            return EfficiencyRating.A.toString();
        }
    }
}
