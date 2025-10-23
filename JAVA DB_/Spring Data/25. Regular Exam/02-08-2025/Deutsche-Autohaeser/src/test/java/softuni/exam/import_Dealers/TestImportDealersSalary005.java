//package softuni.exam.import_Dealers;
////TestImportDealersSalary005
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.jdbc.Sql;
//
//import jakarta.xml.bind.JAXBException;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportDealersSalary005 {
//
//    @Autowired
//    private DealerServiceImpl dealerService;
//
//
//
//    @Sql({"/dealerships-test-imports.sql", "/cars-test-imports.sql"})
//    @Test
//    void importDealersSalary005() throws IOException, JAXBException {
//
//        rewriteFileForTest();
//        String actual = dealerService.importDealers();
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//
//        String expected = "Successfully imported dealer Drake Hawthorne\n" +
//                "Invalid dealer";
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        returnOriginalValue();
//        Assertions.assertArrayEquals(expectedSplit, actualSplit);
//    }
//    private void rewriteFileForTest() {
//        File originalJsonFile = getOriginalFile();
//
//        String testXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<dealers>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>176858.79</average_monthly_turnover>\n" +
//                "        <birthday>1989-01-01</birthday>\n" +
//                "        <first_name>Drake</first_name>\n" +
//                "        <last_name>Hawthorne</last_name>\n" +
//                "        <salary>207615.71</salary>\n" +
//                "        <offering_car_id>50</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>300.79</average_monthly_turnover>\n" +
//                "        <birthday>1989-01-01</birthday>\n" +
//                "        <first_name>Drake</first_name>\n" +
//                "        <last_name>H</last_name>\n" +
//                "        <salary>null</salary>\n" +
//                "        <offering_car_id>50</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "</dealers>";
//
//        try {
//            FileWriter f2 = new FileWriter(originalJsonFile, false);
//            f2.write(testXML);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private File getOriginalFile() {
//        return new File("src/main/resources/files/xml/dealers.xml");
//    }
//
//    private void returnOriginalValue() {
//
//        try {
//            FileWriter f2 = new FileWriter(getOriginalFile(), false);
//            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/dealers.xml"));
//            f2.write(testOriginalFile);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
