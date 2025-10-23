package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "dealerships")
public class Dealership extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    private String name;

    @Column(name = "description", nullable = false)
    @Size(min = 5)
    private String description;

    @OneToMany(mappedBy = "dealership", fetch = FetchType.EAGER)
    private List<Car> cars;

    public Dealership() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}