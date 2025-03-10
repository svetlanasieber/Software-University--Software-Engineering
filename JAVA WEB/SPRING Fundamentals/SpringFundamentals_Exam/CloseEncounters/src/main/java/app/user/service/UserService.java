package app.user.service;

import app.user.model.User;
import app.web.dto.UserLoginDTO;
import app.web.dto.UserProfileDTO;
import app.web.dto.UserRegisterDTO;

import java.util.UUID;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);
    User login(UserLoginDTO userLoginDTO);
    User findById(UUID id);
    void updateProfile(UUID id, UserProfileDTO userProfileDTO);
} 