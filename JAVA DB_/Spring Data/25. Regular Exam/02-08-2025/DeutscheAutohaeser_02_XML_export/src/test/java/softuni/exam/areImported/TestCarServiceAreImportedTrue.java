//package softuni.exam.areImported;
////TestCarServiceAreImportedTrue
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class TestCarServiceAreImportedTrue {
//
//    @InjectMocks
//    private CarServiceImpl carService;
//    @Mock
//    private CarRepository mockCarRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockCarRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(carService.areImported());
//    }
//}