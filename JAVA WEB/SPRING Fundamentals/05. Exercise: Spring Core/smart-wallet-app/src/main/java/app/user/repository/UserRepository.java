package app.user.repository;

import app.user.model.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Fetch(FetchMode.JOIN)
    Optional<User> findByUsername(String username);
}
