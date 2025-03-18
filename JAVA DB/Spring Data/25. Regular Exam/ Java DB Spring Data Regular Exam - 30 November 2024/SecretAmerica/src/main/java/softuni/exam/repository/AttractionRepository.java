package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Attraction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
    Optional<Attraction> findByName(String name);

    @Query("SELECT a FROM Attraction a " +
            "WHERE (a.type = 'historical site' OR a.type = 'archaeological site') " +
            "AND a.elevation >= 300 " +
            "ORDER BY a.name ASC, a.country.name ASC")
    List<Attraction> findAllHistoricalOrArchaeologicalSitesWithElevationAbove300m();
}
