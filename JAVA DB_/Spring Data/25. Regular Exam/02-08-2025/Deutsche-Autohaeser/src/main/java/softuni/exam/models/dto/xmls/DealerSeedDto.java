package softuni.exam.models.dto.xmls;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@XmlRootElement(name = "dealer")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealerSeedDto implements Serializable {

    @XmlElement(name = "first_name")
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement
    @NotNull
    @Positive
    private Double salary;

    @XmlElement(name = "average_monthly_turnover")
    @NotNull
    @Positive
    private Double averageMonthlyTurnover;

    @XmlElement
    private String birthday;

    @XmlElement(name = "offering_car_id")
    private Long offeringCarId;

    public DealerSeedDto() {}

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public void setAverageMonthlyTurnover(Double averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getOfferingCarId() {
        return offeringCarId;
    }

    public void setOfferingCarId(Long offeringCarId) {
        this.offeringCarId = offeringCarId;
    }
}