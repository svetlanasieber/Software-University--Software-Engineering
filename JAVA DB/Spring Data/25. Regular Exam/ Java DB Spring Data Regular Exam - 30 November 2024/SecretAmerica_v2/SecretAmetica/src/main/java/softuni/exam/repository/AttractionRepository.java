package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entity.Attraction;

import java.util.List;
import java.util.Optional;

//ToDo:
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Optional<Attraction> findAttractionByName(String name);
    Attraction findAttractionById(Long id);

    List<Attraction> findAttractionByTypeAndTypeAndElevationGreaterThanEqual(String type1, String type2, int elevation);

    @Query("select a from Attraction a join Country c on c.id = a.country.id " +
            "join Visitor v on v.attraction.id = a.id " +
            "where a.type like 'historical site' or a.type like 'archaeological site'" +
            "and a.elevation >= 300 " +
            "group by a.id, a.name, c.name " +
            "order by a.name, c.name") //COUNT(v.id) DESC,
    List<Attraction> findAttractionByTypeAndElevationMoreThanOrEqualTo300();
}
