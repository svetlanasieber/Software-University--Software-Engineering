package christmasRaces.core.interfaces;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {

        Driver driver = this.driverRepository.getByName(driverName);
        if (driver != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }
        Driver createDiver = new DriverImpl(driverName);
        this.driverRepository.add(createDiver);


        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);

        if (car != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        } else {
            switch (type) {
                case "Muscle":
                    car = new MuscleCar(model, horsePower);
                    break;
                case "Sports":
                    car = new SportsCar(model, horsePower);
                    break;
            }
        }

        this.carRepository.add(car);

        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = this.carRepository.getByName(carModel);
        Driver driver = this.driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));

        }
        driver.addCar(car);


        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        Driver driver = this.driverRepository.getByName(driverName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);
        this.raceRepository.add(race);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Collection<Driver> participants = race.getDrivers();
        if (participants.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
//        for (Driver participant : participants) {
//            if (participant.getCanParticipate()) {
//                participant.getCar().calculateRacePoints(race.getLaps());
//                participant.winRace();
//            }
//        }
        participants.forEach(participant ->{if (participant.getCanParticipate()){
            participant.getCar().calculateRacePoints(race.getLaps());
            participant.winRace();

        }; });

        List<Driver> drivers = participants.stream().sorted(Comparator.comparing(driver -> driver.getCar().calculateRacePoints(race.getLaps()))).collect(Collectors.toList());
        Collections.reverse(drivers);
        String builder = String.format(DRIVER_FIRST_POSITION, drivers.get(0).getName(), race.getName()) + System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION, drivers.get(1).getName(), race.getName()) + System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION, drivers.get(2).getName(), race.getName()) + System.lineSeparator();


        this.raceRepository.remove(race);
        return builder.trim();

    }

    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);
        if (race != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);
        this.raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
