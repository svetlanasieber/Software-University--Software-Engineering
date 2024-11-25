package bg.softuni.jackson.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Message {
    @JacksonXmlProperty
    String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }
}
