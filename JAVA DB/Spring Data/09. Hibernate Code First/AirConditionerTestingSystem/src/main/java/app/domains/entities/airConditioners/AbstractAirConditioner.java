package app.domains.entities.airConditioners;

import app.domains.entities.reports.Report;

import javax.persistence.*;

@Entity
@Table(name = "abstract_air_conditioners")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractAirConditioner {

    private Long id;

    private String manufacturer;

    private String model;

    private Report report;

    public AbstractAirConditioner() {
        super();
    }

    public AbstractAirConditioner(String manufacturer, String model) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "model")
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @OneToOne(mappedBy = "abstractAirConditioner", targetEntity = Report.class)
    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
