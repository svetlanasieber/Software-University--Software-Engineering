package softuni.exam.service.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VisitorSeedRootDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.util.XmlParserImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//ToDo - Implement all the methods

@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String VISITORS_FILE_PATH = "src/main/resources/files/xml/visitors.xml";
    private final VisitorRepository visitorRepository;
    private final ValidationUtil validationUtil;
    private final CountryRepository countryRepository;
    private final AttractionRepository attractionRepository;
    private final PersonalDataRepository personalDataRepository;
    private ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private StringBuilder build;



    public VisitorServiceImpl(VisitorRepository visitorRepository, ValidationUtil validationUtil, CountryRepository countryRepository, AttractionRepository attractionRepository, PersonalDataRepository personalDataRepository, ModelMapper modelMapper, XmlParser xmlParser, StringBuilder build) {
        this.visitorRepository = visitorRepository;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
        this.attractionRepository = attractionRepository;
        this.personalDataRepository = personalDataRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.build = build;
    }

    @Override
    public boolean areImported() {
        return visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {
        return Files.readString(Path.of(VISITORS_FILE_PATH));
    }

    @Override
    public String importVisitors() throws IOException, JAXBException {

        xmlParser.fromFile(VISITORS_FILE_PATH, VisitorSeedRootDTO.class)
                .getVisitorSeedDTOS()
                .stream()
                .filter(visitorSeedDTO -> {
                    boolean isValid = validationUtil.isValid(visitorSeedDTO);

                    Visitor firstName = visitorRepository.findByFirstName(visitorSeedDTO.getFirstName());
                    Visitor lastName = visitorRepository.findByLastName(visitorSeedDTO.getLastName());
                    Visitor personalData = visitorRepository.findByPersonalDataId(visitorSeedDTO.getPersonalData());

                    if (firstName != null && lastName != null || personalData != null) {
                        isValid = false;
                    }

                    build
                            .append(isValid
                                    ? String.format("Successfully imported visitor %s %s",
                                    visitorSeedDTO.getFirstName(),
                                    visitorSeedDTO.getLastName())
                                    : "Invalid visitor")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(visitorSeedDTO -> {

                    Visitor visitor = modelMapper.map(visitorSeedDTO, Visitor.class);

                    Country country = countryRepository.findCountryById(visitorSeedDTO.getCountry());
                    Attraction attraction = attractionRepository.findAttractionById(visitorSeedDTO.getAttraction());
                    PersonalData personalData = personalDataRepository.findPersonalDataById(visitorSeedDTO.getPersonalData());

                    visitor.setCountry(country);
                    visitor.setAttraction(attraction);
                    visitor.setPersonalData(personalData);

                    return visitor;

                })
                .forEach(visitorRepository::save);

        return build.toString();
    }
}
