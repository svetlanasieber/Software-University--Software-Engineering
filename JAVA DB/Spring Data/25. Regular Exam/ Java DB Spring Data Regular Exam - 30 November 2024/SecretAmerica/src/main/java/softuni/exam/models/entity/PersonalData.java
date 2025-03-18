package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "personal_data")
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(1)
    @Max(100)
    @Column(nullable = true)
    private Integer age;

    @PastOrPresent
    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @NotNull
    @Size(min = 9, max = 9)
    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;

    @Pattern(regexp = "^[MF]$")
    @Column(nullable = true)
    private String gender;

    @OneToOne(mappedBy = "personalData")
    private Visitor visitor;

    public PersonalData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
} 