package softuni.exam.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

@XmlRootElement(name = "dealer")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealerImportDto {

    @XmlElement(name = "first_name")
    @Size(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement(name = "salary")
    @Min(0)
    private BigDecimal salary;

    @XmlElement(name = "average_monthly_turnover")
    @Min(0)
    private BigDecimal averageMonthlyTurnover;

    @XmlElement(name = "birthday")
    private String birthday;

    @XmlElement(name = "offering_car_id")
    private Long offeringCarId;

    public DealerImportDto() {
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