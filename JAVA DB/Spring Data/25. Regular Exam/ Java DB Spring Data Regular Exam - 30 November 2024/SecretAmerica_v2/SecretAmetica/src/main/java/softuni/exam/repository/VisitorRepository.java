package softuni.exam.repository;

//ToDo:

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Visitor findByFirstName(String name);

    Visitor findByLastName(String name);

    Visitor findVisitorById(Long id);

    Visitor findVisitorByPersonalDataId(Long id);

    @Query("SELECT v FROM Visitor v WHERE v.personalData.id = :personalDataId")
    Visitor findByPersonalDataId(@Param("personalDataId") Long personalDataId);

}
