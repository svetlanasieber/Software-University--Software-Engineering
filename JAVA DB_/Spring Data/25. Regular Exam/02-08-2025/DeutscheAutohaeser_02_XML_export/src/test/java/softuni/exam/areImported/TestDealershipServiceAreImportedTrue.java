//package softuni.exam.areImported;
////TestDealershipServiceAreImportedTrue
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
//public class TestDealershipServiceAreImportedTrue {
//
//    @InjectMocks
//    private DealershipServiceImpl dealershipService;
//    @Mock
//    private DealershipRepository mockDealershipRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockDealershipRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(dealershipService.areImported());
//    }
//}