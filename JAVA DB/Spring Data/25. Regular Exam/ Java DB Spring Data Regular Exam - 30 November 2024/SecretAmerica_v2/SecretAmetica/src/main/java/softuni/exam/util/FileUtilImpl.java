package softuni.exam.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(String path) throws IOException {
        return new String (Files.readAllBytes(Path.of(path)));
    }
}
