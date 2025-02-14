package app.repositories;

import app.domains.entities.airConditioners.AbstractAirConditioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AirConditionerRepository<E extends AbstractAirConditioner> extends JpaRepository<E, Long> {

    @Query(value = "select a from AbstractAirConditioner AS a WHERE a.manufacturer = :manufacturer AND a.model = :model")
    E findByManufacturerAndModel(@Param(value = "manufacturer") String manufacturer, @Param(value = "model") String model);
}
