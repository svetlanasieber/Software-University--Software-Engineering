package softuni.exam.models.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "personal_datas")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonalDataSeedRootDTO {


    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "personal_data")
    private List<PersonalDataSeedDTO> personalDataSeedDTOS;

    public List<PersonalDataSeedDTO> getPersonalDataSeedDTOS() {
        return personalDataSeedDTOS;
    }

    public PersonalDataSeedRootDTO setPersonalDataSeedDTOS(List<PersonalDataSeedDTO> personalDataSeedDTOS) {
        this.personalDataSeedDTOS = personalDataSeedDTOS;
        return this;
    }
}
