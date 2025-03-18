package softuni.exam.repository;

//ToDo:

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.PersonalData;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    PersonalData findPersonalDataByCardNumber(String cardNumber);

    PersonalData findPersonalDataById(Long id);


}
