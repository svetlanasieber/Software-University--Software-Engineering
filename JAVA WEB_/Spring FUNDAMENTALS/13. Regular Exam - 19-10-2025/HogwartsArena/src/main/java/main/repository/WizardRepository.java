package main.repository;

import main.model.House;
import main.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {

    Optional<Wizard> findByUsername(String username);
    
    boolean existsByUsername(String username);
    
    List<Wizard> findAllByHouse(House house);
}
