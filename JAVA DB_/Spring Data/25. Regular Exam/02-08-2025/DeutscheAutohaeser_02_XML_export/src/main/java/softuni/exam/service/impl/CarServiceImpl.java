package softuni.exam.service.impl;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Dealership;
import softuni.exam.models.entity.enums.CarType;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.DealershipRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private static final String CAR_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final DealershipRepository dealershipRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, DealershipRepository dealershipRepository, 
                         ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.carRepository = carRepository;
        this.dealershipRepository = dealershipRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CAR_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        
        String fileContent = readCarsFileContent();
        CarImportDto[] carImportDtos = gson.fromJson(fileContent, CarImportDto[].class);

        Arrays.stream(carImportDtos)
                .forEach(carImportDto -> {
                    boolean isValid = validationUtil.isValid(carImportDto);
                    
                    if (isValid) {
                        Optional<Car> existingCar = carRepository.findByVIN(carImportDto.getVIN());
                        
                        if (existingCar.isEmpty()) {
                            Optional<Dealership> dealership = dealershipRepository.findById(carImportDto.getDealership());
                            
                            if (dealership.isPresent()) {
                                Car car = modelMapper.map(carImportDto, Car.class);
                                car.setDealership(dealership.get());
                                
                                carRepository.save(car);
                                sb.append(String.format("Successfully imported car %s - %d km.%n", 
                                    car.getBrand(), car.getMileage()));
                            } else {
                                sb.append("Invalid car").append(System.lineSeparator());
                            }
                        } else {
                            sb.append("Invalid car").append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid car").append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }

    @Override
    public String exportCars() {
        List<Car> cars = carRepository.exportCars(CarType.COMBI, 100000);

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(String.format("Brand: %s%n", car.getBrand()));
            sb.append(String.format("   *Mileage: %d km.%n", car.getMileage()));
            sb.append(String.format("   **Model: %s%n", car.getModel()));
            sb.append(String.format("   ***Dealership: %s%n", car.getDealership().getName()));
        }
        return sb.toString();
    }
}