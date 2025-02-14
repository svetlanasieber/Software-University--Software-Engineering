package app.parsers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convert(S source, Class<D> destination) {
        return this.modelMapper.map(source, destination);
    }

    public <S, D> D convert(S source , Class<D> destination, PropertyMap<S, D> propertyMap) {
        this.modelMapper.addMappings(propertyMap);
        return this.modelMapper.map(source, destination);
    }
}
