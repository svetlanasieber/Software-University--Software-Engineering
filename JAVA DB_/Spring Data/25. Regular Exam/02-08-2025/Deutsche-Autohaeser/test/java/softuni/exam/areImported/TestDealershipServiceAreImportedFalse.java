//package softuni.exam.areImported;
////TestDealershipServiceAreImportedFalse
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
//public class TestDealershipServiceAreImportedFalse {
//
//    @InjectMocks
//    private DealershipServiceImpl dealershipService;
//    @Mock
//    private DealershipRepository mockDealershipRepository;
//
//    @Test
//    void areImportedShouldReturnFalse() {
//        Mockito.when(mockDealershipRepository.count()).thenReturn(0L);
//        Assertions.assertFalse(dealershipService.areImported());
//    }
//}