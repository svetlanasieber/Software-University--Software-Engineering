package app.serviceImpls;

import app.domains.entities.airConditioners.AbstractAirConditioner;
import app.repositories.AirConditionerRepository;
import app.domains.dtos.AirConditionerDto;
import app.parsers.ModelParser;
import app.services.AirConditionerService;
import org.springframework.stereotype.Service;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    private final AirConditionerRepository airConditionerRepository;

    private final ModelParser modelParser;

    public AirConditionerServiceImpl(AirConditionerRepository abstractAirConditionerRepository, ModelParser modelParser) {
        this.airConditionerRepository = abstractAirConditionerRepository;
        this.modelParser = modelParser;
    }

    @Override
    public <D> void persist(AirConditionerDto abstractAirConditionerDto, Class<D> destination) {
        D entity = this.modelParser.convert(abstractAirConditionerDto, destination);

        this.airConditionerRepository.saveAndFlush(entity);
    }

    @Override
    public AirConditionerDto findByManufacturerAndModel(String manufacturer, String model) {
        AbstractAirConditioner byManufacturerAndModel = this.airConditionerRepository.findByManufacturerAndModel(manufacturer, model);
        AirConditionerDto airConditionerDto = this.modelParser.convert(byManufacturerAndModel, AirConditionerDto.class);

        return airConditionerDto;
    }
}
