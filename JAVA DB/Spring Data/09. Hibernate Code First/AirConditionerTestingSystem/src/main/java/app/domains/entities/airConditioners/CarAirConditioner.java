package app.domains.entities.airConditioners;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_air_conditioner")
public class CarAirConditioner extends AbstractVehicleAirConditioner {

    public CarAirConditioner() {
        super();
    }

    public CarAirConditioner(String manufacturer, String model, Integer volumeCovered) {
        super(manufacturer, model, volumeCovered);
    }
}
