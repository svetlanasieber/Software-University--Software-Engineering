package bg.softuni.gson;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

public class PersonDTO implements Serializable {
    @Expose
    private String firstName;
    private String lastName;
    @Expose
    private int age;
    @Expose
    private AddressDTO address;
    private boolean isDeleted;
    private Date createdAt;

    public PersonDTO(String firstName, String lastName, int age, AddressDTO address, boolean isDeleted, Date createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
