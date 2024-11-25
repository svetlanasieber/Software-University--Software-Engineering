package bg.softuni.jaxb.entities;

import jakarta.xml.bind.annotation.XmlElement;

public class Address {
    @XmlElement
    private String country;

    @XmlElement
    private String city;

    public Address() {}

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
