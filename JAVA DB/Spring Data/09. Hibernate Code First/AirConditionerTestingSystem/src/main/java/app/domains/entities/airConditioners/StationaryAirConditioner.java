package app.domains.entities.airConditioners;

import app.domains.enums.EfficiencyRating;

import javax.persistence.*;

@Entity
@Table(name = "stationary_air_conditioners")
public class StationaryAirConditioner extends AbstractAirConditioner {

    private EfficiencyRating requiredEfficiencyRating;

    private EfficiencyRating realEfficiencyRating;

    private Integer powerUsage;

    public StationaryAirConditioner() {
        super();
    }

    public StationaryAirConditioner(String manufacturer, String model, EfficiencyRating efficiencyRating, Integer powerUsage) {
        super(manufacturer, model);

        this.setRequiredEfficiencyRating(efficiencyRating);
        this.setPowerUsage(powerUsage);
    }

    @Enumerated(EnumType.STRING)
    public EfficiencyRating getRequiredEfficiencyRating() {
        return this.requiredEfficiencyRating;
    }

    public void setRequiredEfficiencyRating(EfficiencyRating requiredEfficiencyRating) {
        this.requiredEfficiencyRating = requiredEfficiencyRating;
    }

    @Enumerated(EnumType.STRING)
    public EfficiencyRating getRealEfficiencyRating() {
        return this.realEfficiencyRating;
    }

    public void setRealEfficiencyRating(EfficiencyRating realEfficiencyRating) {
        this.realEfficiencyRating = realEfficiencyRating;
    }

    @Column(name = "power_usage")
    public Integer getPowerUsage() {
        return this.powerUsage;
    }

    public void setPowerUsage(Integer powerUsage) {
        this.powerUsage = powerUsage;
    }
}
