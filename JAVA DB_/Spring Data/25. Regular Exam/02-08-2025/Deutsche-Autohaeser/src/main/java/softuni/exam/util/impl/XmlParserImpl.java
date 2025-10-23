package softuni.exam.util.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import softuni.exam.util.XmlParser;

import java.io.FileReader;
import java.io.IOException;

@Component
public class XmlParserImpl implements XmlParser {

    @Override
    public <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}