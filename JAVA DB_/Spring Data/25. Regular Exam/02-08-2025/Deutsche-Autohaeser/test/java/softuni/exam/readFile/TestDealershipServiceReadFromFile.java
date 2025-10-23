//package softuni.exam.readFile;
////TestDealershipServiceReadFromFile
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
//public class TestDealershipServiceReadFromFile {
//
//    @Autowired
//    private DealershipServiceImpl dealershipService;
//
//    @Test
//    void readDealershipsFromFile() throws IOException {
//
//        String expected = """
//                [
//                  {
//                    "name": "Autohaus Sternblick",
//                    "description": "Fahrfreude trifft deutsche Praezision Ihr Autohaus des Vertrauens"
//                  },
//                  {
//                    "name": "Koenig Motoren",
//                    "description": "Koeniglicher Service fuer Ihre Mobilitaet"
//                  },
//                  {
//                    "name": "Koenig Motoren",
//                    "description": "Koeniglicher Service fuer Ihre Mobilitaet"
//                  },
//                  {
//                    "name": "Autotechnik Bergmann",
//                    "description": "Tradition trifft Innovation Ihr Partner fuer Qualitaet"
//                  },
//                  {
//                    "name": "Meisterwagen Lichtenfeld",
//                    "description": "Exklusive Fahrzeuge Persoenliche Beratung Faire Preise"
//                  },
//                  {
//                    "name": "Fahrzeugwelt Neumann",
//                    "description": "Entdecken Sie unsere Welt der Automobile"
//                  },
//                  {
//                    "name": "Autozentrum Falkenstein",
//                    "description": "Stark wie ein Falke Ihr Auto in besten Haenden"
//                  },
//                  {
//                    "name": "Schneider Mobil",
//                    "description": "Mobilitaet mit Stil Schneider machts moeglich"
//                  },
//                  {
//                    "name": "Autohaus Edelkraft",
//                    "description": "Starke Autos Starker Service"
//                  },
//                  {
//                    "name": "Motorpark Lindenhof",
//                    "description": "Ihr Ziel fuer TopGebrauchtwagen und Werkstattqualitaet"
//                  },
//                  {
//                    "name": "RheinMobil",
//                    "description": "Ihre Mobilitaet beginnt hier direkt am Rhein"
//                  },
//                  {
//                    "name": "Gruber Fahrzeughandel",
//                    "description": "Verlaesslichkeit die bewegt"
//                  },
//                  {
//                    "name": "Autohaus Silberstein",
//                    "description": "Wir bringen Glanz in Ihre Garage"
//                  },
//                  {
//                    "name": "Berg & Sohn Automobile",
//                    "description": "Familiengefuehrt Kundenorientiert Fahrzeugbegeistert"
//                  },
//                  {
//                    "name": "Nordstern Auto GmbH",
//                    "description": "Wo Ihre Fahrt beginnt mit Qualitaet aus dem Norden"
//                  },
//                  {
//                    "name": "Kraftmobil Thueringen",
//                    "description": "Zuverlaessige Mobilitaet aus dem Herzen Deutschlands"
//                  },
//                  {
//                    "name": "Vogel & Partner Cars",
//                    "description": "Ihr Autoexperte persoenlich ehrlich kompetent"
//                  },
//                  {
//                    "name": "Autohandel Kaiserblick",
//                    "description": "Kaiserlicher Service zu fairen Preisen"
//                  },
//                  {
//                    "name": "Werkstatt Adlerhorst",
//                    "description": "Schnell Stark Sicher wie ein Adler im Flug"
//                  },
//                  {
//                    "name": "Stadtmobil Breuninger",
//                    "description": "Fahrzeuge fuer Stadtmenschen mit Anspruch"
//                  }
//                ]""";
//
//        String actual = dealershipService.readDealershipsFromFile().replaceAll("\\r", "");
//
//        Assertions.assertEquals(expected, actual.replaceAll("\\r", ""));
//    }
//}