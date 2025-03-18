package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "personal_datas")
public class PersonalData extends BaseEntity{

    private int age;
    private LocalDate birthDate;
    private String cardNumber;
    private char gender;
    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Column(name = "card_number", nullable = false, unique = true)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

//    @OneToOne(mappedBy = "personal_data_id")
//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(Visitor visitor) {
//        this.visitor = visitor;
//    }
}
