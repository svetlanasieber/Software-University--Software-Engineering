package bg.softuni.jackson;

import bg.softuni.jackson.entities.ContactInfo;
import bg.softuni.jackson.entities.Message;
import bg.softuni.jackson.entities.User;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        User user = new User("user", "pass", 20,
                new ContactInfo("email", "0888"),
                List.of(new Message("first"), new Message("second"))
        );

        xmlMapper.writeValue(System.out, user);
        xmlMapper.writeValue(new File("src/main/resources/example-user.xml"), user);

//        User fromXml = xmlMapper.readValue(System.in, User.class);

        System.out.println();
    }
}
