package app.domains.entities.airConditioners;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "plane_air_conditioners")
public class PlaneAirConditioner extends AbstractVehicleAirConditioner {

    private Integer electricityUsed;

    public PlaneAirConditioner() {
        super();
    }

    public PlaneAirConditioner(String manufacturer, String model, Integer volumeCovered, Integer electricityUsed) {
        super(manufacturer, model, volumeCovered);

        this.setElectricityUsed(electricityUsed);
    }

    @Column(name = "electricity_used")
    public Integer getElectricityUsed() {
        return this.electricityUsed;
    }

    public void setElectricityUsed(Integer electricityUsed) {
        this.electricityUsed = electricityUsed;
    }
}
