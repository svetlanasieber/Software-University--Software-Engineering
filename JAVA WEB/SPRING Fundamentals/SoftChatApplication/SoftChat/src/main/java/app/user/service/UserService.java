package app.user.service;

import app.user.model.User;
import app.web.dto.UserLoginDTO;
import app.web.dto.UserProfileDTO;
import app.web.dto.UserRegisterDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UUID registerUser(UserRegisterDTO userRegisterDTO);
    
    Optional<UUID> loginUser(UserLoginDTO userLoginDTO);
    
    User findById(UUID id);
    
    List<User> findAllExceptCurrentUser(UUID currentUserId);
    
    void updateUserProfile(UUID userId, UserProfileDTO userProfileDTO);
} 