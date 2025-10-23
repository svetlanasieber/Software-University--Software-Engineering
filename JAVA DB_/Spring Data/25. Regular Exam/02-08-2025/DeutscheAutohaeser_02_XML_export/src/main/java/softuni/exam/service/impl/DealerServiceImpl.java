package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DealerImportDto;
import softuni.exam.models.dto.DealerRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Dealer;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.DealerRepository;
import softuni.exam.service.DealerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class DealerServiceImpl implements DealerService {

    private static final String DEALER_FILE_PATH = "src/main/resources/files/xml/dealers.xml";

    private final DealerRepository dealerRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public DealerServiceImpl(DealerRepository dealerRepository, CarRepository carRepository, 
                           ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.dealerRepository = dealerRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return dealerRepository.count() > 0;
    }

    @Override
    public String readDealersFromFile() throws IOException {
        return Files.readString(Path.of(DEALER_FILE_PATH));
    }

    @Override
    public String importDealers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        
        String fileContent = readDealersFromFile();
        DealerRootDto dealerRootDto = xmlParser.fromFile(fileContent, DealerRootDto.class);

        dealerRootDto.getDealers()
                .forEach(dealerImportDto -> {
                    boolean isValid = validationUtil.isValid(dealerImportDto);
                    
                    if (isValid) {
                        boolean exists = dealerRepository.existsByFirstNameAndLastName(
                            dealerImportDto.getFirstName(), dealerImportDto.getLastName());
                        
                        if (!exists) {
                            Optional<Car> car = carRepository.findById(dealerImportDto.getOfferingCarId());
                            
                            if (car.isPresent()) {
                                Dealer dealer = modelMapper.map(dealerImportDto, Dealer.class);
                                dealer.setOfferingCar(car.get());
                                
                                
                                if (dealerImportDto.getBirthday() != null && !dealerImportDto.getBirthday().isEmpty()) {
                                    LocalDate birthday = LocalDate.parse(dealerImportDto.getBirthday(), 
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                    dealer.setBirthday(birthday);
                                }
                                
                                dealerRepository.save(dealer);
                                sb.append(String.format("Successfully imported dealer %s %s%n", 
                                    dealer.getFirstName(), dealer.getLastName()));
                            } else {
                                sb.append("Invalid dealer").append(System.lineSeparator());
                            }
                        } else {
                            sb.append("Invalid dealer").append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid dealer").append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }
}
