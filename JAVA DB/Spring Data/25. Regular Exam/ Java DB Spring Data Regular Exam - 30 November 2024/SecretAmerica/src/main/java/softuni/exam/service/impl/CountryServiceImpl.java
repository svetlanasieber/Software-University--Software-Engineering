package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountryFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountryImportDTO[] countryImportDTOs = gson.fromJson(readCountryFileContent(), CountryImportDTO[].class);

        Arrays.stream(countryImportDTOs)
                .forEach(countryImportDTO -> {
                    if (validationUtil.isValid(countryImportDTO)) {
                        Optional<Country> optCountry = countryRepository.findByName(countryImportDTO.getName());

                        if (optCountry.isEmpty()) {
                            Country country = modelMapper.map(countryImportDTO, Country.class);
                            countryRepository.save(country);

                            sb.append(String.format("Successfully imported country %s", country.getName()));
                        } else {
                            sb.append("Invalid country");
                        }
                    } else {
                        sb.append("Invalid country");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
