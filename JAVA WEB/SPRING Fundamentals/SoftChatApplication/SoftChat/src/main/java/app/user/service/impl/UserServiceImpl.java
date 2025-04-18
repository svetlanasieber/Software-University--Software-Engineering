package app.user.service.impl;

import app.user.model.User;
import app.user.repository.UserRepository;
import app.user.service.UserService;
import app.web.dto.UserLoginDTO;
import app.web.dto.UserProfileDTO;
import app.web.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID registerUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(userRegisterDTO.getPassword());
        user.setEmail(userRegisterDTO.getEmail());

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public Optional<UUID> loginUser(UserLoginDTO userLoginDTO) {
        return userRepository.findByUsername(userLoginDTO.getUsername())
                .filter(user -> user.getPassword().equals(userLoginDTO.getPassword()))
                .map(User::getId);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllExceptCurrentUser(UUID currentUserId) {
        return userRepository.findAllExceptCurrentUser(currentUserId);
    }

    @Override
    public void updateUserProfile(UUID userId, UserProfileDTO userProfileDTO) {
        userRepository.findById(userId).ifPresent(user -> {
            if (userProfileDTO.getFirstName() != null && !userProfileDTO.getFirstName().isBlank()) {
                user.setFirstName(userProfileDTO.getFirstName());
            }
            
            if (userProfileDTO.getLastName() != null && !userProfileDTO.getLastName().isBlank()) {
                user.setLastName(userProfileDTO.getLastName());
            }
            
            if (userProfileDTO.getEmail() != null && !userProfileDTO.getEmail().isBlank()) {
                user.setEmail(userProfileDTO.getEmail());
            }
            
            if (userProfileDTO.getPassword() != null && !userProfileDTO.getPassword().isBlank()) {
                user.setPassword(userProfileDTO.getPassword());
            }
            
            if (userProfileDTO.getProfilePicture() != null && !userProfileDTO.getProfilePicture().isBlank()) {
                user.setProfilePicture(userProfileDTO.getProfilePicture());
            }
            
            userRepository.save(user);
        });
    }
} 