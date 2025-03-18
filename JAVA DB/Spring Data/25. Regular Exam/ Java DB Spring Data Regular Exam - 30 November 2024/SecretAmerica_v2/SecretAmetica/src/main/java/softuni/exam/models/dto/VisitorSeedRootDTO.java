package softuni.exam.models.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

//@JacksonXmlRootElement(localName = "visitors")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@XmlRootElement(name = "visitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorSeedRootDTO {

//    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "visitor")
    private List<VisitorSeedDTO> visitorSeedDTOS;

    public List<VisitorSeedDTO> getVisitorSeedDTOS() {
        return visitorSeedDTOS;
    }

    public VisitorSeedRootDTO setVisitorSeedDTOS(List<VisitorSeedDTO> visitorSeedDTOS) {
        this.visitorSeedDTOS = visitorSeedDTOS;
        return this;
    }
}
