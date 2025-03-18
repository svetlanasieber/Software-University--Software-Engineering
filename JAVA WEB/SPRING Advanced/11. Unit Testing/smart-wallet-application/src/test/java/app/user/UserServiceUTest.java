package app.user;

import app.exception.DomainException;
import app.exception.UsernameAlreadyExistException;
import app.notification.service.NotificationService;
import app.security.AuthenticationMetadata;
import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.user.model.Country;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;
import app.user.service.UserService;
import app.wallet.model.Wallet;
import app.wallet.service.WalletService;
import app.web.dto.RegisterRequest;
import app.web.dto.UserEditRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class UserServiceUTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private SubscriptionService subscriptionService;
    @Mock
    private WalletService walletService;
    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private UserService userService;

    @ParameterizedTest
    @MethodSource("userRolesArguments")
    void whenChangeUserRole_theCorrectRoleIsAssigned(UserRole currentUserRole, UserRole expectedUserRole) {

      
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .role(currentUserRole)
                .build();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

      
        userService.switchRole(userId);

     
        assertEquals(expectedUserRole, user.getRole());
    }

    private static Stream<Arguments> userRolesArguments() {

        return Stream.of(
                Arguments.of(UserRole.USER, UserRole.ADMIN),
                Arguments.of(UserRole.ADMIN, UserRole.USER)
        );
    }

    @Test
    void givenExistingUsersInDatabase_whenGetAllUsers_thenReturnThemAll() {

   
        List<User> userList = List.of(new User(), new User());
        when(userRepository.findAll()).thenReturn(userList);

      
        List<User> users = userService.getAllUsers();

        
        assertThat(users).hasSize(2);
    }

   
    @Test
    void givenUserWithStatusActive_whenSwitchStatus_thenUserStatusBecomeInactive() {

     
        User user = User.builder()
                .id(UUID.randomUUID())
                .isActive(true)
                .build();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

       
        userService.switchStatus(user.getId());

      
        assertFalse(user.isActive());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void givenUserWithStatusInactive_whenSwitchStatus_thenUserStatusBecomeActive() {

       
        User user = User.builder()
                .id(UUID.randomUUID())
                .isActive(false)
                .build();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

       
        userService.switchStatus(user.getId());

        
        assertTrue(user.isActive());
        verify(userRepository, times(1)).save(user);
    }


    @Test
    void givenExistingUsername_whenRegister_thenExceptionIsThrown() {

       
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("Svetlana")
                .password("testtest123")
                .country(Country.Switzerland)
                .build();
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(new User()));

      
        assertThrows(UsernameAlreadyExistException.class, () -> userService.register(registerRequest));
        verify(userRepository, never()).save(any());
        verify(subscriptionService, never()).createDefaultSubscription(any());
        verify(walletService, never()).initilizeFirstWallet(any());
        verify(notificationService, never()).saveNotificationPreference(any(UUID.class), anyBoolean(), anyString());
    }

   
    @Test
    void givenHappyPath_whenRegister() {

      
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("svetlana")
                .password("testtest123")
                .country(Country.SWITZERLAND)
                .build();
        User user = User.builder()
                .id(UUID.randomUUID())
                .build();
        when(userRepository.findByUsername(registerRequest.getUsername())).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(user);
        when(subscriptionService.createDefaultSubscription(user)).thenReturn(new Subscription());
        when(walletService.initilizeFirstWallet(user)).thenReturn(new Wallet());

      
        User registeredUser = userService.register(registerRequest);

      
        assertThat(registeredUser.getSubscriptions()).hasSize(1);
        assertThat(registeredUser.getWallets()).hasSize(1);
        verify(notificationService, times(1)).saveNotificationPreference(user.getId(), false, null);
    }

 
    @Test
    void givenMissingUserFromDatabase_whenLoadUserByUsername_thenExceptionIsThrown() {

       
        String username = "svetlana";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        
        assertThrows(DomainException.class, () -> userService.loadUserByUsername(username));
    }

   
    @Test
    void givenExistingUser_whenLoadUserByUsername_thenReturnCorrectAuthenticationMetadata() {

      
        String username = "svetlana";
        User user = User.builder()
                .id(UUID.randomUUID())
                .isActive(true)
                .password("svetla123")
                .role(UserRole.ADMIN)
                .build();
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserDetails authenticationMetadata = userService.loadUserByUsername(username);

       
        assertInstanceOf(AuthenticationMetadata.class, authenticationMetadata);
        AuthenticationMetadata result = (AuthenticationMetadata) authenticationMetadata;
        assertEquals(user.getId(), result.getUserId());
        assertEquals(username, result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.isActive(), result.isActive());
        assertEquals(user.getRole(), result.getRole());
        assertThat(result.getAuthorities()).hasSize(1);
        assertEquals("ROLE_ADMIN", result.getAuthorities().iterator().next().getAuthority());
    }

 
    @Test
    void givenMissingUserFromDatabase_whenEditUserDetails_thenExceptionIsThrown() {

        UUID userId = UUID.randomUUID();
        UserEditRequest dto = UserEditRequest.builder().build();
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(DomainException.class, () -> userService.editUserDetails(userId, dto));
    }


    @Test
    void givenExistingUser_whenEditTheirProfileWithActualEmail_thenChangeTheirDetailsSaveNotificationPreferenceAndSaveToDatabase() {

       
        UUID userId = UUID.randomUUID();
        UserEditRequest dto = UserEditRequest.builder()
                .firstName("Svetlana")
                .lastName("Sieber")
                .email("sieber.test@gmail.com")
                .profilePicture("www.image.com")
                .build();
        User user = User.builder().build();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        
        userService.editUserDetails(userId, dto);

        
        assertEquals("Svetlana", user.getFirstName());
        assertEquals("Sieber", user.getLastName());
        assertEquals("sieber.test@gmail.com", user.getEmail());
        assertEquals("www.image.com", user.getProfilePicture());
        verify(notificationService, times(1)).saveNotificationPreference(userId, true, dto.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void givenExistingUser_whenEditTheirProfileWithEmptyEmail_thenChangeTheirDetailsSaveNotificationPreferenceAndSaveToDatabase() {

       
        UUID userId = UUID.randomUUID();
        UserEditRequest dto = UserEditRequest.builder()
                .firstName("Svetlana")
                .lastName("Sieber")
                .email("")
                .profilePicture("www.image.com")
                .build();
        User user = User.builder().build();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

      
        userService.editUserDetails(userId, dto);

      
        assertEquals("Svetlana", user.getFirstName());
        assertEquals("Sieber", user.getLastName());
        assertEquals("", user.getEmail());
        assertEquals("www.image.com", user.getProfilePicture());
        verify(notificationService, times(1)).saveNotificationPreference(userId, false, null);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void givenUserWithRoleAdmin_whenSwitchRole_thenUserReceivesUserRole() {

      
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .role(UserRole.ADMIN)
                .build();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

      
        userService.switchRole(userId);

       
        assertThat(user.getRole()).isEqualTo(UserRole.USER);
    }

    @Test
    void givenUserWithRoleUser_whenSwitchRole_thenUserReceivesAdminRole() {

     
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .role(UserRole.USER)
                .build();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

       
        userService.switchRole(userId);

       
        assertThat(user.getRole()).isEqualTo(UserRole.ADMIN);
    }
}
