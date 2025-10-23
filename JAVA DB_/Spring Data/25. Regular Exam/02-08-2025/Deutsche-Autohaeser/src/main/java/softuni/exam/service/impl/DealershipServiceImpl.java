package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.jsons.DealershipSeedDto;
import softuni.exam.models.entity.Dealership;
import softuni.exam.repository.DealershipRepository;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class DealershipServiceImpl implements DealershipService {

    // For local testing
    // private static final String DEALERSHIPS_FILE_PATH = "C:\\Users\\siebe\\OneDrive\\Documents\\CursorTestProject\\SpringData2025\\Deutsche-Autohaeser\\src\\main\\resources\\files\\json\\dealerships.json";
    // For Judge
    private static final String DEALERSHIPS_FILE_PATH = "src/main/resources/files/json/dealerships.json";

    private final DealershipRepository dealershipRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public DealershipServiceImpl(DealershipRepository dealershipRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.dealershipRepository = dealershipRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.dealershipRepository.count() > 0;
    }

    @Override
    public String readDealershipsFromFile() throws IOException {
        return Files.readString(Path.of(DEALERSHIPS_FILE_PATH));
    }

    @Override
    public String importDealerships() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        DealershipSeedDto[] dealershipSeedDtos = this.gson.fromJson(
                new FileReader(DEALERSHIPS_FILE_PATH), DealershipSeedDto[].class);

        for (DealershipSeedDto dealershipSeedDto : dealershipSeedDtos) {
            Optional<Dealership> optionalDealership = this.dealershipRepository.findByName(dealershipSeedDto.getName());
            if (!this.validationUtil.isValid(dealershipSeedDto) || optionalDealership.isPresent()) {
                stringBuilder.append("Invalid dealership\n");
                continue;
            }

            Dealership dealership = this.modelMapper.map(dealershipSeedDto, Dealership.class);
            this.dealershipRepository.saveAndFlush(dealership);
            stringBuilder.append(String.format("Successfully imported dealership %s\n", dealership.getName()));
        }

        return stringBuilder.toString();
    }
}