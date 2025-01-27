package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
}