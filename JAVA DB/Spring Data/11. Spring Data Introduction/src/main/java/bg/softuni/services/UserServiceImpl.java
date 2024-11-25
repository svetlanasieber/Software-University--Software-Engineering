package bg.softuni.services;

import bg.softuni.entities.Account;
import bg.softuni.entities.User;
import bg.softuni.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(int id) {
        Optional<User> byId = userRepository.findById(id);

        return byId.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addAccountWithBalance(User user, int balance) {
        // Check if user is persisted?

        user.getAccounts().add(new Account(BigDecimal.valueOf(balance)));

        userRepository.save(user);
    }

    @Override
    public User getByAccount(int accountId) {
        return userRepository.findByAccountsId(accountId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
