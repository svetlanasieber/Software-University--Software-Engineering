//package softuni.exam.areImported;
////TestDealerServiceAreImportedTrue
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
//public class TestDealerServiceAreImportedTrue {
//
//    @InjectMocks
//    private DealerServiceImpl dealerService;
//    @Mock
//    private DealerRepository mockDealerRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockDealerRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(dealerService.areImported());
//    }
//}