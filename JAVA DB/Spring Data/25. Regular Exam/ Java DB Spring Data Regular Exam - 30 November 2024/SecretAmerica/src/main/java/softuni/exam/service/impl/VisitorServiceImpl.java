package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VisitorImportDTO;
import softuni.exam.models.dto.VisitorImportRootDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String VISITORS_FILE_PATH = "src/main/resources/files/xml/visitors.xml";

    private final VisitorRepository visitorRepository;
    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final PersonalDataRepository personalDataRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VisitorServiceImpl(VisitorRepository visitorRepository, AttractionRepository attractionRepository, CountryRepository countryRepository, PersonalDataRepository personalDataRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.visitorRepository = visitorRepository;
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.personalDataRepository = personalDataRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
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
        StringBuilder sb = new StringBuilder();

        VisitorImportRootDTO visitorRoot = xmlParser.fromFile(VISITORS_FILE_PATH, VisitorImportRootDTO.class);

        for (VisitorImportDTO visitorDTO : visitorRoot.getVisitors()) {
            if (validationUtil.isValid(visitorDTO)) {
                Optional<Visitor> optVisitor = visitorRepository.findByFirstNameAndLastName(
                        visitorDTO.getFirstName(), visitorDTO.getLastName());

                Optional<PersonalData> optPersonalData = personalDataRepository.findById(visitorDTO.getPersonalDataId());

                if (optVisitor.isEmpty() && optPersonalData.isPresent() && 
                    visitorRepository.findByPersonalData(optPersonalData.get()).isEmpty()) {
                    
                    Optional<Attraction> optAttraction = attractionRepository.findById(visitorDTO.getAttractionId());
                    Optional<Country> optCountry = countryRepository.findById(visitorDTO.getCountryId());

                    if (optAttraction.isPresent() && optCountry.isPresent()) {
                        Visitor visitor = modelMapper.map(visitorDTO, Visitor.class);
                        visitor.setAttraction(optAttraction.get());
                        visitor.setCountry(optCountry.get());
                        visitor.setPersonalData(optPersonalData.get());

                        visitorRepository.save(visitor);

                        sb.append(String.format("Successfully imported visitor %s %s", 
                                visitor.getFirstName(), visitor.getLastName()));
                    } else {
                        sb.append("Invalid visitor");
                    }
                } else {
                    sb.append("Invalid visitor");
                }
            } else {
                sb.append("Invalid visitor");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
