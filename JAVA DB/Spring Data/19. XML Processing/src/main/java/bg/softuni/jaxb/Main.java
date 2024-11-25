package bg.softuni.jaxb;

import bg.softuni.jaxb.entities.Address;
import bg.softuni.jaxb.entities.Names;
import bg.softuni.jaxb.entities.Person;
import bg.softuni.jaxb.entities.PhoneNumber;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Names names = new Names("First", "Last");
        Person person = new Person(
            names,
            20,
            new Address("BG", "Burgas"),
            List.of(new PhoneNumber("alabala"), new PhoneNumber("0888181818181"))
        );

        JAXBContext nameContext = JAXBContext.newInstance(Names.class);
        Marshaller nameMarshaller = nameContext.createMarshaller();
        nameMarshaller.marshal(person, System.out);

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(person, System.out);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Person fromXml = (Person) unmarshaller.unmarshal(System.in);

        System.out.println();
    }
}