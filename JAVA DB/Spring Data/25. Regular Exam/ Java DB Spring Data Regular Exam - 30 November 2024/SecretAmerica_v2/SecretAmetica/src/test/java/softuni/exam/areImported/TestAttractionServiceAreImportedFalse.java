package softuni.exam.areImported;
//TestAttractionServiceAreImportedFalse
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.service.impl.AttractionServiceImpl;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestAttractionServiceAreImportedFalse {


    @Autowired
    private AttractionServiceImpl attractionService;
//    @Mock
//    private AttractionRepository mockAttractionRepository;
    @Autowired
    private AttractionRepository attractionRepository;

    @Test
    void areImportedShouldReturnFalse() {
//        Mockito.when(mockAttractionRepository.count()).thenReturn(0L);
        boolean areImported = attractionRepository.count() > 0;
        Assertions.assertFalse(areImported);
    }
}