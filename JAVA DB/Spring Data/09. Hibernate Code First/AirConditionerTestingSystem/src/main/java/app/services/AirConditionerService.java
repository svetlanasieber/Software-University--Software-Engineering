package app.services;

import app.domains.dtos.AirConditionerDto;

public interface AirConditionerService {

    <D> void persist(AirConditionerDto abstractAirConditionerDto, Class<D> destination);

    AirConditionerDto findByManufacturerAndModel(String manufacturer, String model);
}
