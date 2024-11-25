package bg.softuni.gson;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressDTO implements Serializable {
    @Expose
    private String country;
    @Expose
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
