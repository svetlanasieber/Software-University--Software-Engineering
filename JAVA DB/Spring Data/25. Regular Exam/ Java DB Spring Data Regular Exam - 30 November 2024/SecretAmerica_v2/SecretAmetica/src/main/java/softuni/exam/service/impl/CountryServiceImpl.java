package softuni.exam.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

//ToDo - Implement all the methods
@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private ObjectMapper objectMapper;
    private ModelMapper modelMapper;
    private StringBuilder build;
    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    public CountryServiceImpl(CountryRepository countryRepository, ValidationUtil validationUtil, ObjectMapper objectMapper, ModelMapper modelMapper, StringBuilder build) {
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.build = build;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountryFileContent() throws IOException {
        return Files
                .readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {

        Arrays.stream(objectMapper.readValue(readCountryFileContent(), CountrySeedDTO[].class))
                .filter(countrySeedDTO -> {
                boolean isValid = validationUtil.isValid(countrySeedDTO);

                    Optional<Country> countryName = countryRepository.findCountryByName(countrySeedDTO.getName());
                    if(countryName.isPresent()) {
                        isValid = false;
                    }

                    build.append(isValid
                                    ? String.format("Successfully imported country %s",
                                    countrySeedDTO.getName())
                                    : "Invalid country")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(countrySeedDTO -> modelMapper.map(countrySeedDTO, Country.class))
                .forEach(countryRepository::save);
        System.out.println(modelMapper.hashCode());

        return build.toString();
    }

//    public Optional<Country> getCountryById(Long countryId) {
//        return countryRepository.findById(countryId);
//    }
}
