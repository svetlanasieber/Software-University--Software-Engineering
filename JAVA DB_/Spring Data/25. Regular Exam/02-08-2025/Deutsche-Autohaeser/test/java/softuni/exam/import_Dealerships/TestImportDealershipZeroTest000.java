//package softuni.exam.import_Dealerships;
////TestImportDealershipZeroTest000
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.io.IOException;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportDealershipZeroTest000 {
//    @Autowired
//    private DealershipServiceImpl dealershipService;
//
//
//
//    @Test
//    void importDealershipsZeroTest() throws IOException {
//        String actual = dealershipService.importDealerships();
//
//        String expected = """
//                Successfully imported dealership Autohaus Sternblick
//                Successfully imported dealership Koenig Motoren
//                Invalid dealership
//                Successfully imported dealership Autotechnik Bergmann
//                Successfully imported dealership Meisterwagen Lichtenfeld
//                Successfully imported dealership Fahrzeugwelt Neumann
//                Successfully imported dealership Autozentrum Falkenstein
//                Successfully imported dealership Schneider Mobil
//                Successfully imported dealership Autohaus Edelkraft
//                Successfully imported dealership Motorpark Lindenhof
//                Successfully imported dealership RheinMobil
//                Successfully imported dealership Gruber Fahrzeughandel
//                Successfully imported dealership Autohaus Silberstein
//                Successfully imported dealership Berg & Sohn Automobile
//                Successfully imported dealership Nordstern Auto GmbH
//                Successfully imported dealership Kraftmobil Thueringen
//                Successfully imported dealership Vogel & Partner Cars
//                Successfully imported dealership Autohandel Kaiserblick
//                Successfully imported dealership Werkstatt Adlerhorst
//                Successfully imported dealership Stadtmobil Breuninger""";
//
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        Assertions.assertArrayEquals(expectedSplit,actualSplit);
//    }
//}
