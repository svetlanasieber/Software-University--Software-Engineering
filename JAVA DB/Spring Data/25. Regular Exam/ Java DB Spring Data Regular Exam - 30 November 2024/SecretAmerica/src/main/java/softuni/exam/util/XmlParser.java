package softuni.exam.util;

import jakarta.xml.bind.JAXBException;

public interface XmlParser {

    <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException;

    <T> void writeToFile(String filePath, T entity) throws JAXBException;
} 