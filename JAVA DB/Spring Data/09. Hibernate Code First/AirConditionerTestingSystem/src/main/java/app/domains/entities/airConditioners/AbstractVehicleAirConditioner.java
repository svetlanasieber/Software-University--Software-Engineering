package app.domains.entities.airConditioners;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "abstract_vehicle_air_conditioners")
public abstract class AbstractVehicleAirConditioner extends AbstractAirConditioner {

    private Integer volumeCovered;

    public AbstractVehicleAirConditioner() {
        super();
    }

    public AbstractVehicleAirConditioner(String manufacturer, String model, Integer volumeCovered) {
        super(manufacturer, model);

        this.setVolumeCovered(volumeCovered);
    }

    public Integer getVolumeCovered() {
        return this.volumeCovered;
    }

    public void setVolumeCovered(Integer volumeCovered) {
        this.volumeCovered = volumeCovered;
    }
}
