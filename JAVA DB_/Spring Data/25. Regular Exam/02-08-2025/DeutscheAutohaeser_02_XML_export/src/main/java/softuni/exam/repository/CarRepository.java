package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.enums.CarType;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByVIN(String VIN);
    
    boolean existsByVIN(String VIN);

    @Query("select c from Car as c where c.carType = :carType and c.mileage < :carMileage order by c.mileage desc")
    List<Car> exportCars(@Param("carType") CarType carType, @Param("carMileage") Integer carMileage);
}