//package softuni.exam.areImported;
////TestDealerServiceAreImportedFalse
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
//public class TestDealerServiceAreImportedFalse {
//
//
//    @InjectMocks
//    private DealerServiceImpl dealerService;
//    @Mock
//    private DealerRepository mockDealerRepository;
//
//    @Test
//    void areImportedShouldReturnFalse() {
//        Mockito.when(mockDealerRepository.count()).thenReturn(0L);
//        Assertions.assertFalse(dealerService.areImported());
//    }
//}