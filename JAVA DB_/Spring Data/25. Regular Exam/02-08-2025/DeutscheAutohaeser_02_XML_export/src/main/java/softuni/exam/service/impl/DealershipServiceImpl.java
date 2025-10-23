package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DealershipImportDto;
import softuni.exam.models.entity.Dealership;
import softuni.exam.repository.DealershipRepository;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class DealershipServiceImpl implements DealershipService {

    private static final String DEALERSHIP_FILE_PATH = "src/main/resources/files/json/dealerships.json";

    private final DealershipRepository dealershipRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public DealershipServiceImpl(DealershipRepository dealershipRepository, ModelMapper modelMapper, 
                                ValidationUtil validationUtil, Gson gson) {
        this.dealershipRepository = dealershipRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return dealershipRepository.count() > 0;
    }

    @Override
    public String readDealershipsFromFile() throws IOException {
        return Files.readString(Path.of(DEALERSHIP_FILE_PATH));
    }

    @Override
    public String importDealerships() throws IOException {
        StringBuilder sb = new StringBuilder();
        
        String fileContent = readDealershipsFromFile();
        DealershipImportDto[] dealershipImportDtos = gson.fromJson(fileContent, DealershipImportDto[].class);

        Arrays.stream(dealershipImportDtos)
                .forEach(dealershipImportDto -> {
                    boolean isValid = validationUtil.isValid(dealershipImportDto);
                    
                    if (isValid) {
                        boolean exists = dealershipRepository.existsByName(dealershipImportDto.getName());
                        
                        if (!exists) {
                            Dealership dealership = modelMapper.map(dealershipImportDto, Dealership.class);
                            dealershipRepository.save(dealership);
                            sb.append(String.format("Successfully imported dealership %s%n", dealership.getName()));
                        } else {
                            sb.append("Invalid dealership").append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid dealership").append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }
}