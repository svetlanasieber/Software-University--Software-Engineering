package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "dealerships")
public class Dealership extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "dealership", fetch = FetchType.EAGER)
    private Set<Car> cars;

    public Dealership() {}

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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}