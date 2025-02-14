package app.core.commands;

import app.annotations.Inject;
import app.domains.dtos.AirConditionerDto;
import app.domains.dtos.ReportDto;
import app.domains.enums.EfficiencyRating;
import app.domains.enums.Mark;
import app.services.AirConditionerService;
import app.services.ReportService;

public class TestAirConditionerCommand extends AbstractCommand {

    @Inject
    private ReportService reportService;

    @Inject
    private AirConditionerService airConditionerService;

    public TestAirConditionerCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String manufacturer = super.getData()[0];
        String model = super.getData()[1];

        ReportDto reportDto = new ReportDto();
        AirConditionerDto airConditionerDto = this.airConditionerService.findByManufacturerAndModel(manufacturer, model);
        reportDto.setAirConditionerDto(airConditionerDto);


        String mark = this.testAirConditioner(airConditionerDto);
        reportDto.setMark(mark);
        this.reportService.persist(reportDto);

        return String.format("Air Conditioner model %s from %s tested successfully.",
                airConditionerDto.getModel(), airConditionerDto.getManufacturer());
    }

    private String testAirConditioner(AirConditionerDto airConditionerDto) {
        String required = airConditionerDto.getRequiredEfficiencyRating();
        String real = airConditionerDto.getRealEfficiencyRating();

        EfficiencyRating requiredER = EfficiencyRating.valueOf(required);
        EfficiencyRating realER = EfficiencyRating.valueOf(real);

        if (realER.ordinal() < requiredER.ordinal()) {
            return Mark.FAILED.toString();
        }

        return Mark.PASSED.toString();
    }
}
