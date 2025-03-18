package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "personal_datas")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataImportRootDTO {

    @XmlElement(name = "personal_data")
    private List<PersonalDataImportDTO> personalData;

    public PersonalDataImportRootDTO() {
    }

    public List<PersonalDataImportDTO> getPersonalData() {
        return personalData;
    }

    public void setPersonalData(List<PersonalDataImportDTO> personalData) {
        this.personalData = personalData;
    }
} 