package app.domains.dtos;

public class ReportDto {

    private String mark;

    private AirConditionerDto airConditionerDto;

    public ReportDto() {
        super();
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public AirConditionerDto getAirConditionerDto() {
        return this.airConditionerDto;
    }

    public void setAirConditionerDto(AirConditionerDto airConditionerDto) {
        this.airConditionerDto = airConditionerDto;
    }
}
