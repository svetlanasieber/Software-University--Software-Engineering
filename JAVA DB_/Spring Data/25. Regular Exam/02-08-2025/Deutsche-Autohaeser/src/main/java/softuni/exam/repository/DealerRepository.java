package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Dealer;

import java.util.Optional;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

    Optional<Dealer> findByFirstNameAndLastName(String firstName, String lastName);
}