package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);
//        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        System.out.println("Mapped User: " + user);

        userRepository.save(user);
    }
}