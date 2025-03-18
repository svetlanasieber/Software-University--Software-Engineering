package softuni.exam.models.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitor extends BaseEntity {

    private Attraction attraction;
    private Country country;
    private String firstName;
    private String lastName;
    private PersonalData personalData;


    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @ManyToOne
    @JoinColumn(name = "attraction_id", nullable = false)
    public Attraction getAttraction() {
        return attraction;
    }
    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @OneToOne()
    @JoinColumn(name = "personal_data_id", nullable = false)
    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }
}
