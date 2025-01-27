package app.user.service;

import app.exception.DomainException;
import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.user.model.User;
import app.user.property.UserProperties;
import app.user.repository.UserRepository;
import app.wallet.model.Wallet;
import app.wallet.service.WalletService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import app.web.dto.UserEditRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SubscriptionService subscriptionService;
    private final WalletService walletService;
    private final UserProperties userProperties;

    public UserService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       SubscriptionService subscriptionService,
                       WalletService walletService, UserProperties userProperties) {

        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.subscriptionService = subscriptionService;
        this.walletService = walletService;
        this.userProperties = userProperties;
    }

    public User login(LoginRequest loginRequest) {

        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional.isEmpty()) {
            throw new DomainException("User with username=[%s] does not exist.".formatted(loginRequest.getUsername()), HttpStatus.BAD_REQUEST);
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new DomainException("Login attempt with incorrect password for user with id [%s].".formatted(user.getId()), HttpStatus.BAD_REQUEST);
        }

        return user;
    }

    @Transactional
    public User register(RegisterRequest registerRequest) {

        Optional<User> userOptional = userRepository.findByUsername(registerRequest.getUsername());
        if (userOptional.isPresent()) {
            throw new DomainException("User with username=[%s] already exist.".formatted(registerRequest.getUsername()), HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.save(initializeNewUserAccount(registerRequest));

        Subscription defaultSubscription = subscriptionService.createDefaultSubscription(user);
        ArrayList<Subscription> userSubscriptions = new ArrayList<>();
        userSubscriptions.add(defaultSubscription);
        user.setSubscriptions(userSubscriptions);

        Wallet wallet = walletService.createNewWallet(user);
        ArrayList<Wallet> userWallets = new ArrayList<>();
        userWallets.add(wallet);
        user.setWallets(userWallets);

        log.info("Successfully created new user for username [%s] with id [%s].".formatted(user.getUsername(), user.getId()));

        return userRepository.save(user);
    }

    private User initializeNewUserAccount(RegisterRequest dto) {

        return User.builder()
                .id(UUID.randomUUID())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(userProperties.getDefaultRole())
                .isActive(userProperties.isActiveByDefault())
                .country(dto.getCountry())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public User getById(UUID userId) {

        return userRepository
                .findById(userId)
                .orElseThrow(() -> new DomainException("User with id [%s] does not exist.".formatted(userId), HttpStatus.BAD_REQUEST));
    }

    public User editUser(UUID userId, UserEditRequest userEditRequest) {

        User user = getById(userId);

        user.setFirstName(userEditRequest.getFirstName().trim());
        user.setLastName(userEditRequest.getLastName().trim());
        user.setEmail(userEditRequest.getEmail().trim());
        user.setProfilePicture(userEditRequest.getProfilePicture().trim());
        user.setUpdatedOn(LocalDateTime.now());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public void switchStatus(UUID userId) {

        User user = getById(userId);

        user.setUpdatedOn(LocalDateTime.now());
        user.setActive(!user.isActive());

        userRepository.save(user);
    }
}
