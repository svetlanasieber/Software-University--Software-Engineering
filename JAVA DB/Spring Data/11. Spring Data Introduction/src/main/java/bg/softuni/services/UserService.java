package bg.softuni.services;

import bg.softuni.entities.User;

public interface UserService {
    void register(User user);

    User get(int id);

    void addAccountWithBalance(User user, int balance);

    User getByAccount(int accountId);
}
