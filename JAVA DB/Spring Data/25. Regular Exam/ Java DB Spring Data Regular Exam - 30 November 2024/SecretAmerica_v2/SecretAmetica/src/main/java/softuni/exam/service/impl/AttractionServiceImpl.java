package softuni.exam.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.models.dto.AttractionSeedDTO;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//ToDo - Implement all the methods
@Service
@Configuration
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;
    private final ValidationUtil validationUtil;
    private final CountryRepository countryRepository;
    private final CountryServiceImpl countryService;
    private FileUtil fileUtil;
    private ModelMapper modelMapper;
    private ObjectMapper objectMapper;
    private final VisitorRepository visitorRepository;
    private StringBuilder build;

    private static final String ATTRACTION_FILE_PATH = "src/main/resources/files/json/attractions.json";

    public AttractionServiceImpl(AttractionRepository attractionRepository,
                                 ValidationUtil validationUtil,
                                 CountryRepository countryRepository,
                                 CountryServiceImpl countryService,
                                 FileUtil fileUtil, ModelMapper modelMapper, ObjectMapper objectMapper,
                                 VisitorRepository visitorRepository, StringBuilder build) {
        this.attractionRepository = attractionRepository;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
        this.countryService = countryService;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.visitorRepository = visitorRepository;
        this.build = build;
    }

    @Override
    public boolean areImported() {
        return attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return
                fileUtil.readFile(ATTRACTION_FILE_PATH);
    }

    @Override
    public String importAttractions() throws IOException {

        Arrays.stream(objectMapper.readValue(readAttractionsFileContent(), AttractionSeedDTO[].class))
                .filter(attractionDTO -> {
                    boolean isValid = validationUtil.isValid(attractionDTO);

                    Optional<Attraction> attractionName = attractionRepository.findAttractionByName(attractionDTO.getName());
                    if (attractionName.isPresent()) {
                        isValid = false;
                    }

                    build.append(isValid
                                    ? String.format("Successfully imported attraction %s",
                                    attractionDTO.getName())
                                    : "Invalid attraction")
                            .append(System.lineSeparator());

                    return isValid;
                })


                .map(attractionDTO -> {
                    Attraction attraction = modelMapper.map(attractionDTO, Attraction.class);

//                    Optional<Country> country = countryRepository.findById(attractionDTO.getCountry());
                    Country country = countryRepository.findCountryById(attractionDTO.getCountry());
//                    Country country = countryService.getCountryById(attractionDTO.getCountry()).orElse(null);
//                    assert country.isPresent();
//                    country.get().getAttractions().add(attraction);
                    Visitor visitor = visitorRepository.findVisitorById(attractionDTO.getVisitor());

                    attraction.setCountry(country);
                    country.getAttractions().add(attraction); //additional
                    countryRepository.save(country); //additional
                    return attraction;

                })
                .forEach(attractionRepository::save);
        System.out.println(build.hashCode());

        return build.toString();
    }

    @Override
    public String exportAttractions() {

        StringBuilder build = new StringBuilder();

        List<Attraction> foundAttractions = attractionRepository
                .findAttractionByTypeAndElevationMoreThanOrEqualTo300();

        foundAttractions.forEach(a -> {
//            build.append(String.format("Attraction with ID%d:\n" +
//                                    "***%s - %s" +
//                                    " at an altitude of %dm. somewhere in %s.",
            build.append(String.format("""
                                    Attraction with ID%d:
                                    ***%s - %s at an altitude of %dm. somewhere in %s.""",

                            a.getId(),
                            a.getName(),
                            a.getDescription(),
                            a.getElevation(),
                            a.getCountry().getName()))
                    .append(System.lineSeparator());

        });
        return build.toString();
    }
}
