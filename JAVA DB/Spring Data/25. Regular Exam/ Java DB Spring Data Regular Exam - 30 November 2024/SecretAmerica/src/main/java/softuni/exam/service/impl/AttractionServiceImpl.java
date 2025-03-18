package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AttractionImportDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl implements AttractionService {

    private static final String ATTRACTIONS_FILE_PATH = "src/main/resources/files/json/attractions.json";

    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public AttractionServiceImpl(AttractionRepository attractionRepository, CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return Files.readString(Path.of(ATTRACTIONS_FILE_PATH));
    }

    @Override
    public String importAttractions() throws IOException {
        StringBuilder sb = new StringBuilder();

        AttractionImportDTO[] attractionImportDTOs = gson.fromJson(readAttractionsFileContent(), AttractionImportDTO[].class);

        Arrays.stream(attractionImportDTOs)
                .forEach(attractionImportDTO -> {
                    if (validationUtil.isValid(attractionImportDTO)) {
                        Optional<Attraction> optAttraction = attractionRepository.findByName(attractionImportDTO.getName());

                        if (optAttraction.isEmpty()) {
                            Optional<Country> optCountry = countryRepository.findById(attractionImportDTO.getCountry());

                            if (optCountry.isPresent()) {
                                Attraction attraction = modelMapper.map(attractionImportDTO, Attraction.class);
                                attraction.setCountry(optCountry.get());
                                attractionRepository.save(attraction);

                                sb.append(String.format("Successfully imported attraction %s", attraction.getName()));
                            } else {
                                sb.append("Invalid attraction");
                            }
                        } else {
                            sb.append("Invalid attraction");
                        }
                    } else {
                        sb.append("Invalid attraction");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public String exportAttractions() {
        StringBuilder sb = new StringBuilder();

        List<Attraction> attractions = attractionRepository.findAllHistoricalOrArchaeologicalSitesWithElevationAbove300m();

        attractions.forEach(attraction -> {
            sb.append(String.format("Attraction with ID%d:%n", attraction.getId()));
            sb.append(String.format("***%s - %s at an altitude of %.0fm. somewhere in %s.%n",
                    attraction.getName(),
                    attraction.getDescription(),
                    attraction.getElevation(),
                    attraction.getCountry().getName()));
        });

        return sb.toString().trim();
    }
}
