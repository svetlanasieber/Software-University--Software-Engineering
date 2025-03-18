package softuni.exam.util;

import org.springframework.stereotype.Component;

import jakarta.xml.bind.*;
import java.io.File;

@Component
public class XmlParserImpl implements XmlParser {


    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new File(filePath));
    }
}
