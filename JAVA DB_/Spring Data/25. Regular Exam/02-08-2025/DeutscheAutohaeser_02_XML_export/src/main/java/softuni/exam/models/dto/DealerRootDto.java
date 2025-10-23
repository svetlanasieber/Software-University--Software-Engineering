package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "dealers")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealerRootDto {

    @XmlElement(name = "dealer")
    private List<DealerImportDto> dealers;

    public DealerRootDto() {
    }

    public List<DealerImportDto> getDealers() {
        return dealers;
    }

    public void setDealers(List<DealerImportDto> dealers) {
        this.dealers = dealers;
    }
}