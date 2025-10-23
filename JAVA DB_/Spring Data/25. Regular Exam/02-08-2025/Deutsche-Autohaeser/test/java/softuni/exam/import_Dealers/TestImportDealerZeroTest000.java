//package softuni.exam.import_Dealers;
////TestImportDealerZeroTest000
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.jdbc.Sql;
//
//import jakarta.xml.bind.JAXBException;
//import java.io.IOException;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportDealerZeroTest000 {
//
//    @Autowired
//    private DealerServiceImpl dealerService;
//
//    @Sql({"/dealerships-test-imports.sql", "/cars-test-imports.sql"})
//    @Test
//    void importDealersZeroTest() throws IOException, JAXBException {
//        String expected = """
//                Successfully imported dealer Drake Hawthorne
//                Invalid dealer
//                Invalid dealer
//                Successfully imported dealer Elena Sullivan
//                Successfully imported dealer Cassandra Bellamy
//                Successfully imported dealer Victor Adams
//                Invalid dealer
//                Successfully imported dealer Nathaniel Reynolds
//                Successfully imported dealer Serena Chandler
//                Successfully imported dealer Gabriel Fletcher
//                Successfully imported dealer Lorelei Blackwell
//                Successfully imported dealer Sebastian Maxwell
//                Successfully imported dealer Aurora Hamilton
//                Successfully imported dealer Julian Whitaker
//                Successfully imported dealer Genevieve Archer
//                Successfully imported dealer Elias Donovan
//                Successfully imported dealer Isadora Fitzgerald
//                Successfully imported dealer Lysander Spencer
//                Successfully imported dealer Astrid Webster
//                Successfully imported dealer Leander Valentine
//                Successfully imported dealer Helena Bishop
//                Successfully imported dealer Dorian Sawyer
//                Successfully imported dealer Vivienne Griffin""";
//
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        String actual = dealerService.importDealers();
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//
//
//
//        Assertions.assertArrayEquals(expectedSplit, actualSplit);
//    }
//}
//
