package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "visitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorImportDTO {

    @XmlElement(name = "first_name")
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @XmlElement(name = "attraction_id")
    @NotNull
    private Integer attractionId;

    @XmlElement(name = "country_id")
    @NotNull
    private Integer countryId;

    @XmlElement(name = "personal_data_id")
    @NotNull
    private Integer personalDataId;

    public VisitorImportDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Integer attractionId) {
        this.attractionId = attractionId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(Integer personalDataId) {
        this.personalDataId = personalDataId;
    }
} 