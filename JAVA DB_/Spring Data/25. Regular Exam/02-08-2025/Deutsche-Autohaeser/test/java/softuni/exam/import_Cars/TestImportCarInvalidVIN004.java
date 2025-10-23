//package softuni.exam.import_Cars;
////TestImportCarDuplicateVINs001
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.jdbc.Sql;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportCarInvalidVIN004 {
//
//    @Autowired
//    private CarServiceImpl carService;
//
//    @Test
//    @Sql("/dealerships-test-imports.sql")
//    void importCarsInvalidVIN() throws IOException {
//
//        copyRewriteFileForTest();
//
//        String expected = "Successfully imported car Hyundai - 157163 km.\n" +
//                "Invalid car\n" +
//                "Successfully imported car Skoda - 212014 km.\n";
//
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//        String actual = carService.importCars();
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//
//        returnOriginalValue();
//        Assertions.assertArrayEquals(expectedSplit, actualSplit);
//    }
//
//    private void copyRewriteFileForTest() throws IOException {
//        File originalJsonFile = getOriginalFile();
//
//        String testJSON = "[\n" +
//                "  {\n" +
//                "    \"brand\": \"Hyundai\",\n" +
//                "    \"model\": \"Veloster\",\n" +
//                "    \"VIN\": \"QDYV4OEGWZSV79653\",\n" +
//                "    \"mileage\": 157163,\n" +
//                "    \"carType\": \"COUPE\",\n" +
//                "    \"dealership\": 1\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"brand\": \"BMW\",\n" +
//                "    \"model\": \"M3\",\n" +
//                "    \"VIN\": \"Z3FTF3BMZXHV558\",\n" +
//                "    \"mileage\": 57163,\n" +
//                "    \"carType\": \"COUPE\",\n" +
//                "    \"dealership\": 1\n" +
//                "  },\n" +
//                "  {\n" +
//                "   \"brand\": \"Skoda\",\n" +
//                "    \"model\": \"Scala\",\n" +
//                "    \"VIN\": \"I0QHZ8TNJBQA24ITV\",\n" +
//                "    \"mileage\": 212014,\n" +
//                "    \"carType\": \"HATCHBACK\",\n" +
//                "    \"dealership\": 18\n" +
//                "  }\n" +
//                "]";
//
//        try {
//            FileWriter f2 = new FileWriter(originalJsonFile, false);
//            f2.write(testJSON);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private File getOriginalFile() {
//        return new File("src/main/resources/files/json/cars.json");
//    }
//
//    private void returnOriginalValue() {
//
//        try {
//            FileWriter f2 = new FileWriter(getOriginalFile(), false);
//            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/cars.json"));
//            f2.write(testOriginalFile);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
