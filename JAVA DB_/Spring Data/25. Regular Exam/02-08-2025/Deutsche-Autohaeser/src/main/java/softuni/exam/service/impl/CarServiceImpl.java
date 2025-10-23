package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.jsons.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Dealership;
import softuni.exam.models.enums.CarType;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.DealershipRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    // For local testing
    // private static final String CARS_FILE_PATH = "C:\\Users\\siebe\\OneDrive\\Documents\\CursorTestProject\\SpringData2025\\Deutsche-Autohaeser\\src\\main\\resources\\files\\json\\cars.json";
    // For Judge
    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final DealershipRepository dealershipRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, DealershipRepository dealershipRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.carRepository = carRepository;
        this.dealershipRepository = dealershipRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        CarSeedDto[] carSeedDtos = this.gson.fromJson(
                new FileReader(CARS_FILE_PATH), CarSeedDto[].class);

        for (CarSeedDto carSeedDto : carSeedDtos) {
            Optional<Car> optionalCar = this.carRepository.findByVIN(carSeedDto.getVIN());
            Optional<Dealership> optionalDealership = this.dealershipRepository.findById(carSeedDto.getDealership());
            
            if (!this.validationUtil.isValid(carSeedDto) || optionalCar.isPresent() || optionalDealership.isEmpty()) {
                stringBuilder.append("Invalid car\n");
                continue;
            }

            Car car = this.modelMapper.map(carSeedDto, Car.class);
            car.setCarType(CarType.valueOf(carSeedDto.getCarType()));
            car.setDealership(optionalDealership.get());

            this.carRepository.saveAndFlush(car);
            stringBuilder.append(String.format("Successfully imported car %s - %d km.\n", car.getBrand(), car.getMileage()));
        }

        return stringBuilder.toString();
    }

    @Override
    public String exportCars() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Car> cars = this.carRepository.findAllByCarTypeAndMileageLessThanOrderByMileageDesc(CarType.COMBI, 100000);

        cars.forEach(car -> {
            stringBuilder.append(String.format(Locale.US, "Brand: %s\n", car.getBrand()))
                    .append(String.format(Locale.US, "    *Mileage: %.2f km.\n", car.getMileage().doubleValue()))
                    .append(String.format(Locale.US, "    **Model: %s\n", car.getModel()))
                    .append(String.format(Locale.US, "    ***Dealership: %s\n", car.getDealership().getName()));
        });

        return stringBuilder.toString();
    }
}