package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Dealership;

import java.util.Optional;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long> {

    Optional<Dealership> findByName(String name);
}