package bg.softuni.jaxb.entities;

import jakarta.xml.bind.annotation.XmlElement;

public class PhoneNumber {
    @XmlElement
    private String number;

    public PhoneNumber() {}

    public PhoneNumber(String number) {
        this.number = number;
    }
}
