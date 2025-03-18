package softuni.exam.models.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@JacksonXmlRootElement
public class PersonalDataSeedDTO {

    @JacksonXmlProperty(localName = "age")
    private int age;
    @JacksonXmlProperty(localName = "birth_date")
    private LocalDate birthDate;
    @JacksonXmlProperty(localName = "card_number")
    private String cardNumber;
    @JacksonXmlProperty(localName = "gender")
    private char gender;


    @Min(1)
    @Max(100)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Size(min = 9, max = 9)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
