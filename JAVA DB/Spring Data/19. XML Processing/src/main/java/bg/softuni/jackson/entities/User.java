package bg.softuni.jackson.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "user")
public class User {
    @JacksonXmlProperty
    private String username;

    @JacksonXmlProperty(isAttribute = true)
    private String password;

    @JacksonXmlProperty
    private int accountAge;

    @JacksonXmlProperty
    private ContactInfo contactInfo;

    @JacksonXmlElementWrapper(localName = "messages")
    @JacksonXmlProperty(localName = "singleMessage")
    private List<Message> messages;

    public User() {}

    public User(String username, String password, int accountAge, ContactInfo contactInfo, List<Message> messages) {
        this.username = username;
        this.password = password;
        this.accountAge = accountAge;
        this.contactInfo = contactInfo;
        this.messages = messages;
    }
}
