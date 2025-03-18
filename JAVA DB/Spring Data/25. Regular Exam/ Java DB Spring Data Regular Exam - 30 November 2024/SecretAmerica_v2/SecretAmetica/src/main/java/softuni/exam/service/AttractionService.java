package softuni.exam.service;

import softuni.exam.util.FileUtil;

import java.io.IOException;

public interface AttractionService {

    boolean areImported();

    String readAttractionsFileContent() throws IOException;

    String importAttractions() throws IOException;

    String exportAttractions();

}
