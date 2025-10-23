package softuni.exam.service;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

public interface DealerService {

    boolean areImported();

    String readDealersFromFile() throws IOException;

	String importDealers() throws IOException, JAXBException;

}
