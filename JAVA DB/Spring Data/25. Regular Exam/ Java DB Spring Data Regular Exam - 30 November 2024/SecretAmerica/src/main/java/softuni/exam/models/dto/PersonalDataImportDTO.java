package softuni.exam.models.dto;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personal_data")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataImportDTO {

    @XmlElement(name = "age")
    @Min(1)
    @Max(100)
    private Integer age;

    @XmlElement(name = "gender")
    @Pattern(regexp = "^[MF]$")
    private String gender;

    @XmlElement(name = "birth_date")
    private String birthDate;

    @XmlElement(name = "card_number")
    @NotNull
    @Size(min = 9, max = 9)
    private String cardNumber;

    public PersonalDataImportDTO() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
} 