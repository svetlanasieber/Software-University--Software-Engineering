//package softuni.exam.export;
////TestStarServiceExport001DEL
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.jdbc.Sql;
//
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestCarServiceExport001 {
//
//    @Autowired
//    private CarServiceImpl carService;
//
//    @Sql("/export-test-001.sql")
//    @Test
//    void exportCars001() {
//        String actual = carService.exportCars();
//
//        String expected = """
//                Brand: BMW
//                   *Mileage: 99461 km.
//                   **Model: 5er Touring
//                   ***Dealership: Gruber Fahrzeughandel
//                Brand: Volkswagen
//                   *Mileage: 97794 km.
//                   **Model: Passat Variant
//                   ***Dealership: Schneider Mobil
//                Brand: Peugeot
//                   *Mileage: 83613 km.
//                   **Model: 308 SW
//                   ***Dealership: Nordstern Auto GmbH
//                Brand: Ford
//                   *Mileage: 80545 km.
//                   **Model: Focus Turnier
//                   ***Dealership: Meisterwagen Lichtenfeld
//                Brand: BMW
//                   *Mileage: 74783 km.
//                   **Model: 5er Touring
//                   ***Dealership: Autozentrum Falkenstein
//                Brand: Mercedes-Benz
//                   *Mileage: 67725 km.
//                   **Model: C-Klasse T-Modell
//                   ***Dealership: Autohaus Edelkraft
//                Brand: Volkswagen
//                   *Mileage: 58660 km.
//                   **Model: Passat Variant
//                   ***Dealership: Werkstatt Adlerhorst
//                Brand: Peugeot
//                   *Mileage: 54243 km.
//                   **Model: 308 SW
//                   ***Dealership: Berg & Sohn Automobile
//                Brand: BMW
//                   *Mileage: 33336 km.
//                   **Model: 5er Touring
//                   ***Dealership: RheinMobil
//                Brand: Hyundai
//                   *Mileage: 25989 km.
//                   **Model: i30 Kombi
//                   ***Dealership: Autotechnik Bergmann
//                Brand: Volkswagen
//                   *Mileage: 12521 km.
//                   **Model: Passat Variant
//                   ***Dealership: Autohandel Kaiserblick""";
//
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        Assertions.assertArrayEquals(expectedSplit,actualSplit);
//    }
//}
