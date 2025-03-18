package softuni.exam.service;

import java.io.IOException;

public interface PersonalDataService {

    boolean areImported();

    String readPersonalDataFileContent() throws IOException;

    String importPersonalData() throws IOException;
}
