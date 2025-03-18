package softuni.exam.service;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface VisitorService {

    boolean areImported();

    String readVisitorsFileContent() throws IOException;

    String importVisitors() throws IOException, JAXBException;

}
