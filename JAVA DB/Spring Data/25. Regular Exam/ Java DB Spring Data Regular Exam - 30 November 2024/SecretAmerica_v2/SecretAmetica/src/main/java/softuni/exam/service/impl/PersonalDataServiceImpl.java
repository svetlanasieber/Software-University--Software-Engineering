package softuni.exam.service.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonalDataSeedRootDTO;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.service.PersonalDataService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//ToDo - Implement all the methods

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private final PersonalDataRepository personalDataRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private StringBuilder build;

    private static final String PERSONAL_DATA_FILE_PATH = "src/main/resources/files/xml/personal_data.xml";

    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository, ValidationUtil validationUtil, ModelMapper modelMapper, StringBuilder build) {
        this.personalDataRepository = personalDataRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.build = build;
    }

    @Override
    public boolean areImported() {
        return personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return Files
                .readString(Path.of(PERSONAL_DATA_FILE_PATH));
    }

    @Override
    public String importPersonalData() throws IOException {

        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.registerModule(new JavaTimeModule());

        xmlMapper
                .readValue(readPersonalDataFileContent(), PersonalDataSeedRootDTO.class)
                .getPersonalDataSeedDTOS()
                .stream()
                .filter(personalDataSeedDTO -> {
                    boolean isValid = validationUtil.isValid(personalDataSeedDTO);

                    PersonalData personalData = personalDataRepository
                            .findPersonalDataByCardNumber(personalDataSeedDTO.getCardNumber());

                    if (personalData != null) {
                        isValid = false;
                    }

                    build
                            .append(isValid
                                    ? String.format("Successfully imported personal data for visitor with card number %s",
                                    personalDataSeedDTO.getCardNumber())
                                    : "Invalid personal data")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(personalDataSeedDTO -> modelMapper.map(personalDataSeedDTO, PersonalData.class))
                .forEach(personalDataRepository::save);
        System.out.println(modelMapper.hashCode());

        return build.toString();
    }
}
