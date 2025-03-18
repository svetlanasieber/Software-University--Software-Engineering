package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "visitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorImportRootDTO {

    @XmlElement(name = "visitor")
    private List<VisitorImportDTO> visitors;

    public VisitorImportRootDTO() {
    }

    public List<VisitorImportDTO> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<VisitorImportDTO> visitors) {
        this.visitors = visitors;
    }
} 