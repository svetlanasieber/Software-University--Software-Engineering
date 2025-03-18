package softuni.exam.import_PersonalData;
//TestImportPersonalDataZeroTest000

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.PersonalDataServiceImpl;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportPersonalDataZeroTest000 {

    @Autowired
    private PersonalDataServiceImpl personalDataService;

    @Test
    void importPersonalDataZeroTest() throws IOException, JAXBException {
        String expected = """
                Successfully imported personal data for visitor with card number 123456789
                Invalid personal data
                Successfully imported personal data for visitor with card number 987654321
                Successfully imported personal data for visitor with card number 234567890
                Successfully imported personal data for visitor with card number 345678901
                Successfully imported personal data for visitor with card number 456789012
                Successfully imported personal data for visitor with card number 567890123
                Successfully imported personal data for visitor with card number 678901234
                Successfully imported personal data for visitor with card number 789012345
                Successfully imported personal data for visitor with card number 890123456
                Successfully imported personal data for visitor with card number 901234567
                Successfully imported personal data for visitor with card number 102345678
                Successfully imported personal data for visitor with card number 213456789
                Successfully imported personal data for visitor with card number 324567890
                Successfully imported personal data for visitor with card number 435678901
                Successfully imported personal data for visitor with card number 546789012
                Successfully imported personal data for visitor with card number 657890123
                Successfully imported personal data for visitor with card number 768901234
                Successfully imported personal data for visitor with card number 879012345
                Successfully imported personal data for visitor with card number 980123456
                Successfully imported personal data for visitor with card number 123456780
                Successfully imported personal data for visitor with card number 234567891
                Successfully imported personal data for visitor with card number 345678902
                Successfully imported personal data for visitor with card number 456789013
                Successfully imported personal data for visitor with card number 567890124
                Successfully imported personal data for visitor with card number 678901235
                Successfully imported personal data for visitor with card number 789012346
                Successfully imported personal data for visitor with card number 890123457
                Successfully imported personal data for visitor with card number 901234568
                Successfully imported personal data for visitor with card number 102345679
                Successfully imported personal data for visitor with card number 213456780
                Successfully imported personal data for visitor with card number 324567891
                Successfully imported personal data for visitor with card number 435678902
                Successfully imported personal data for visitor with card number 546789013
                Successfully imported personal data for visitor with card number 657890124
                Successfully imported personal data for visitor with card number 768901235
                Successfully imported personal data for visitor with card number 879012346
                Successfully imported personal data for visitor with card number 980123457
                Successfully imported personal data for visitor with card number 123456791
                Successfully imported personal data for visitor with card number 234567892
                Successfully imported personal data for visitor with card number 345678903
                Successfully imported personal data for visitor with card number 456789014
                Successfully imported personal data for visitor with card number 567890125
                Successfully imported personal data for visitor with card number 678901236
                Successfully imported personal data for visitor with card number 789012347
                Successfully imported personal data for visitor with card number 890123458
                Successfully imported personal data for visitor with card number 901234569
                Successfully imported personal data for visitor with card number 102345680
                Successfully imported personal data for visitor with card number 213456791
                Successfully imported personal data for visitor with card number 324567892
                Successfully imported personal data for visitor with card number 435678903
                Successfully imported personal data for visitor with card number 546789014
                Successfully imported personal data for visitor with card number 657890125
                Successfully imported personal data for visitor with card number 768901236
                Successfully imported personal data for visitor with card number 879012347
                Successfully imported personal data for visitor with card number 980123458
                Successfully imported personal data for visitor with card number 123456792
                Successfully imported personal data for visitor with card number 234567893
                Successfully imported personal data for visitor with card number 345678904
                Successfully imported personal data for visitor with card number 456789015
                Successfully imported personal data for visitor with card number 567890126
                Successfully imported personal data for visitor with card number 678901237
                Successfully imported personal data for visitor with card number 789012348
                Successfully imported personal data for visitor with card number 890123459
                Successfully imported personal data for visitor with card number 901234570
                Successfully imported personal data for visitor with card number 102345681
                Successfully imported personal data for visitor with card number 213456792
                Successfully imported personal data for visitor with card number 324567893
                Successfully imported personal data for visitor with card number 435678904
                Successfully imported personal data for visitor with card number 546789015
                Successfully imported personal data for visitor with card number 657890126
                Successfully imported personal data for visitor with card number 768901237
                Successfully imported personal data for visitor with card number 879012348
                Successfully imported personal data for visitor with card number 980123459
                Successfully imported personal data for visitor with card number 123456793
                """;

        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = personalDataService.importPersonalData();
        String[] actualSplit = actual.split("\\r\\n?|\\n");


        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}

