package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dealers")
public class Dealer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 30)
    private String lastName;

    @Column(name = "salary", nullable = false)
    @Min(0)
    private BigDecimal salary;

    @Column(name = "average_monthly_turnover", nullable = false)
    @Min(0)
    private BigDecimal averageMonthlyTurnover;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offering_car_id", referencedColumnName = "id")
    private Car offeringCar;

    public Dealer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public void setAverageMonthlyTurnover(BigDecimal averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Car getOfferingCar() {
        return offeringCar;
    }

    public void setOfferingCar(Car offeringCar) {
        this.offeringCar = offeringCar;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}