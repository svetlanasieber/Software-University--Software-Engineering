package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xmls.DealerSeedDto;
import softuni.exam.models.dto.xmls.DealerSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Dealer;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.DealerRepository;
import softuni.exam.service.DealerService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class DealerServiceImpl implements DealerService {

    // For local testing
    // private static final String DEALERS_FILE_PATH = "C:\\Users\\siebe\\OneDrive\\Documents\\CursorTestProject\\SpringData2025\\Deutsche-Autohaeser\\src\\main\\resources\\files\\xml\\dealers.xml";
    // For Judge
    private static final String DEALERS_FILE_PATH = "src/main/resources/files/xml/dealers.xml";

    private final DealerRepository dealerRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public DealerServiceImpl(DealerRepository dealerRepository, CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.dealerRepository = dealerRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.dealerRepository.count() > 0;
    }

    @Override
    public String readDealersFromFile() throws IOException {
        return Files.readString(Path.of(DEALERS_FILE_PATH));
    }

    @Override
    public String importDealers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(DealerSeedRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        DealerSeedRootDto dealerSeedRootDto = (DealerSeedRootDto) unmarshaller.unmarshal(new FileReader(DEALERS_FILE_PATH));

        for (DealerSeedDto dealerSeedDto : dealerSeedRootDto.getDealers()) {
            Optional<Dealer> optionalDealer = this.dealerRepository.findByFirstNameAndLastName(
                    dealerSeedDto.getFirstName(), dealerSeedDto.getLastName());
            Optional<Car> optionalCar = this.carRepository.findById(dealerSeedDto.getOfferingCarId());
            
            if (!this.validationUtil.isValid(dealerSeedDto) || optionalDealer.isPresent() || optionalCar.isEmpty()) {
                stringBuilder.append("Invalid dealer\n");
                continue;
            }

            Dealer dealer = this.modelMapper.map(dealerSeedDto, Dealer.class);
            dealer.setOfferingCar(optionalCar.get());
            
            if (dealerSeedDto.getBirthday() != null && !dealerSeedDto.getBirthday().isEmpty()) {
                dealer.setBirthday(LocalDate.parse(dealerSeedDto.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }

            this.dealerRepository.saveAndFlush(dealer);
            stringBuilder.append(String.format("Successfully imported dealer %s %s\n", dealer.getFirstName(), dealer.getLastName()));
        }

        return stringBuilder.toString();
    }
}