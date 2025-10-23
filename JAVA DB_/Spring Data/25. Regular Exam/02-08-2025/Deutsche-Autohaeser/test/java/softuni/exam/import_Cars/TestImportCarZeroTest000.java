//package softuni.exam.import_Cars;
////TestImportCarZeroTest000
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.jdbc.Sql;
//
//import java.io.IOException;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportCarZeroTest000 {
//
//    @Autowired
//    private CarServiceImpl starService;
//
//    @Test
//    @Sql("/dealerships-test-imports.sql")
//    void importStarsZeroTest() throws IOException {
//
//        String expected =
//                """
//                        Successfully imported car Hyundai - 157163 km.
//                        Invalid car
//                        Successfully imported car Skoda - 212014 km.
//                        Successfully imported car Volkswagen - 38437 km.
//                        Successfully imported car Skoda - 193030 km.
//                        Successfully imported car BMW - 243387 km.
//                        Successfully imported car Volkswagen - 120509 km.
//                        Successfully imported car Skoda - 162856 km.
//                        Successfully imported car Volkswagen - 100603 km.
//                        Successfully imported car Volkswagen - 227142 km.
//                        Successfully imported car Skoda - 30879 km.
//                        Successfully imported car Kia - 186224 km.
//                        Successfully imported car Mercedes-Benz - 68901 km.
//                        Successfully imported car BMW - 7038 km.
//                        Successfully imported car Skoda - 59591 km.
//                        Successfully imported car Skoda - 145344 km.
//                        Successfully imported car Skoda - 36552 km.
//                        Successfully imported car BMW - 99461 km.
//                        Successfully imported car Kia - 56676 km.
//                        Successfully imported car Skoda - 232773 km.
//                        Successfully imported car Hyundai - 216381 km.
//                        Successfully imported car Volkswagen - 12521 km.
//                        Successfully imported car Skoda - 108421 km.
//                        Successfully imported car Kia - 133607 km.
//                        Successfully imported car Volkswagen - 97638 km.
//                        Successfully imported car Skoda - 107237 km.
//                        Successfully imported car Audi - 20667 km.
//                        Successfully imported car Audi - 165283 km.
//                        Successfully imported car Kia - 61278 km.
//                        Successfully imported car Mercedes-Benz - 95229 km.
//                        Successfully imported car Audi - 168551 km.
//                        Successfully imported car Mercedes-Benz - 93766 km.
//                        Successfully imported car Peugeot - 124009 km.
//                        Successfully imported car BMW - 141774 km.
//                        Successfully imported car Skoda - 112987 km.
//                        Successfully imported car Ford - 151257 km.
//                        Successfully imported car Volkswagen - 120441 km.
//                        Successfully imported car Peugeot - 191640 km.
//                        Successfully imported car Audi - 92311 km.
//                        Successfully imported car Kia - 134624 km.
//                        Successfully imported car Volkswagen - 186934 km.
//                        Successfully imported car Audi - 176004 km.
//                        Successfully imported car Hyundai - 161424 km.
//                        Successfully imported car Skoda - 83897 km.
//                        Successfully imported car Ford - 46505 km.
//                        Successfully imported car Skoda - 193941 km.
//                        Successfully imported car Peugeot - 223446 km.
//                        Successfully imported car Kia - 84092 km.
//                        Successfully imported car BMW - 74783 km.
//                        Successfully imported car Ford - 79089 km.
//                        Successfully imported car Ford - 218996 km.
//                        Successfully imported car Kia - 237419 km.
//                        Successfully imported car Opel - 138750 km.
//                        Successfully imported car Hyundai - 139465 km.
//                        Successfully imported car Mercedes-Benz - 171922 km.
//                        Successfully imported car Peugeot - 83613 km.
//                        Successfully imported car Audi - 6087 km.
//                        Successfully imported car Opel - 29556 km.
//                        Successfully imported car BMW - 113221 km.
//                        Successfully imported car Mercedes-Benz - 172312 km.
//                        Successfully imported car Hyundai - 208488 km.
//                        Successfully imported car Hyundai - 183970 km.
//                        Successfully imported car Opel - 47390 km.
//                        Successfully imported car Audi - 237204 km.
//                        Successfully imported car Peugeot - 220475 km.
//                        Successfully imported car Audi - 161414 km.
//                        Successfully imported car Volkswagen - 214090 km.
//                        Successfully imported car BMW - 142638 km.
//                        Successfully imported car Peugeot - 54243 km.
//                        Successfully imported car Mercedes-Benz - 120929 km.
//                        Successfully imported car BMW - 160288 km.
//                        Successfully imported car Volkswagen - 97794 km.
//                        Successfully imported car Kia - 219699 km.
//                        Successfully imported car Peugeot - 136838 km.
//                        Successfully imported car Mercedes-Benz - 153218 km.
//                        Successfully imported car Ford - 156943 km.
//                        Successfully imported car Peugeot - 232067 km.
//                        Successfully imported car Ford - 80545 km.
//                        Successfully imported car BMW - 224181 km.
//                        Successfully imported car Mercedes-Benz - 67725 km.
//                        Successfully imported car Volkswagen - 199147 km.
//                        Successfully imported car Kia - 156690 km.
//                        Successfully imported car Mercedes-Benz - 14449 km.
//                        Successfully imported car Peugeot - 238493 km.
//                        Successfully imported car Volkswagen - 58660 km.
//                        Successfully imported car BMW - 33336 km.
//                        Successfully imported car Ford - 11308 km.
//                        Successfully imported car Ford - 50921 km.
//                        Successfully imported car Volkswagen - 170874 km.
//                        Successfully imported car Audi - 172551 km.
//                        Successfully imported car Volkswagen - 150118 km.
//                        Successfully imported car Skoda - 182829 km.
//                        Successfully imported car Skoda - 10002 km.
//                        Successfully imported car Opel - 194737 km.
//                        Successfully imported car Audi - 138160 km.
//                        Successfully imported car Hyundai - 25989 km.
//                        Successfully imported car Opel - 233761 km.
//                        Successfully imported car Kia - 17865 km.
//                        Successfully imported car Volkswagen - 121994 km.
//                        Successfully imported car Volkswagen - 33944 km.
//                        Successfully imported car Ford - 31138 km.
//                        """;
//
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//        String actual = starService.importCars();
//        String[] actualSplit = actual.split("\\r\\n?|\\n");
//
//        Assertions.assertArrayEquals(expectedSplit, actualSplit);
//    }
//
//
//}
