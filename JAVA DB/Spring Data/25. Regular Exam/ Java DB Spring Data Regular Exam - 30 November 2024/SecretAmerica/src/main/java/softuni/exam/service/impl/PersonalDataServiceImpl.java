package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonalDataImportDTO;
import softuni.exam.models.dto.PersonalDataImportRootDTO;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.service.PersonalDataService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private static final String PERSONAL_DATA_FILE_PATH = "src/main/resources/files/xml/personal_data.xml";

    private final PersonalDataRepository personalDataRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.personalDataRepository = personalDataRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return Files.readString(Path.of(PERSONAL_DATA_FILE_PATH));
    }

    @Override
    public String importPersonalData() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PersonalDataImportRootDTO personalDataRoot = xmlParser.fromFile(PERSONAL_DATA_FILE_PATH, PersonalDataImportRootDTO.class);

        for (PersonalDataImportDTO personalDataDTO : personalDataRoot.getPersonalData()) {
            if (validationUtil.isValid(personalDataDTO)) {
                Optional<PersonalData> optPersonalData = personalDataRepository.findByCardNumber(personalDataDTO.getCardNumber());

                if (optPersonalData.isEmpty()) {
                    PersonalData personalData = modelMapper.map(personalDataDTO, PersonalData.class);

                    if (personalDataDTO.getBirthDate() != null && !personalDataDTO.getBirthDate().isEmpty()) {
                        LocalDate birthDate = LocalDate.parse(personalDataDTO.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        personalData.setBirthDate(birthDate);
                    }

                    personalDataRepository.save(personalData);

                    sb.append(String.format("Successfully imported personal data for visitor with card number %s", personalData.getCardNumber()));
                } else {
                    sb.append("Invalid personal data");
                }
            } else {
                sb.append("Invalid personal data");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
