package app.user.service;

import app.user.model.User;
import app.user.repository.UserRepository;
import app.web.dto.UserLoginDTO;
import app.web.dto.UserProfileDTO;
import app.web.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByUsername(userRegisterDTO.getUsername())) {
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(user);
        return true;
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        Optional<User> userOptional = userRepository.findByUsername(userLoginDTO.getUsername());

        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return null;
        }

        return user;
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProfile(UUID id, UserProfileDTO userProfileDTO) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstName(userProfileDTO.getFirstName());
            user.setLastName(userProfileDTO.getLastName());
            user.setEmail(userProfileDTO.getEmail());
            user.setProfilePicture(userProfileDTO.getProfilePicture());

            userRepository.save(user);
        }
    }
} 