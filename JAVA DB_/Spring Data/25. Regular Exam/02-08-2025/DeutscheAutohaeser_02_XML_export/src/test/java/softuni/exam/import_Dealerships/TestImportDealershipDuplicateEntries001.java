//package softuni.exam.import_Dealerships;
////TestImportDealershipDuplicateEntries001
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportDealershipDuplicateEntries001 {
//
//    @Autowired
//    private DealershipServiceImpl dealershipService;
//
//
//    @Test
//    void importDealershipDuplicateEntries001() throws IOException {
//        String expected = "Successfully imported dealership Autohaus Sternblick\n" +
//                "Invalid dealership\n" +
//                "Successfully imported dealership Koenig Motoren";
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        copyRewriteFileForTest();
//        String actual = dealershipService.importDealerships();
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//
//        returnOriginalValue();
//        Assertions.assertArrayEquals(expectedSplit,actualSplit);
//    }
//
//    private void copyRewriteFileForTest() throws IOException {
//        File originalJsonFile = new File("src/main/resources/files/json/dealerships.json");
//
//        String testJSON = "[\n" +
//                "  {\n" +
//                "    \"name\": \"Autohaus Sternblick\",\n" +
//                "    \"description\": \"Fahrfreude trifft deutsche Praezision Ihr Autohaus des Vertrauens\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"name\": \"Autohaus Sternblick\",\n" +
//                "    \"description\": \"Fahrfreude trifft deutsche Praezision Ihr Autohaus des Vertrauens\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"name\": \"Koenig Motoren\",\n" +
//                "    \"description\": \"Koeniglicher Service fuer Ihre Mobilitaet\"\n" +
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
//    private void returnOriginalValue() {
//        File originalJsonFileSrc = new File("src/main/resources/files/json/dealerships.json");
//
//        try {
//            FileWriter f2 = new FileWriter(originalJsonFileSrc, false);
//            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/dealerships.json"));
//            f2.write(testOriginalFile);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
