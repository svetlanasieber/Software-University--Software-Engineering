package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.enums.CarType;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByVIN(String vin);

    @Query("SELECT c FROM Car c WHERE c.carType = :carType AND c.mileage < :mileage ORDER BY c.mileage DESC")
    List<Car> findAllByCarTypeAndMileageLessThanOrderByMileageDesc(CarType carType, Integer mileage);
}