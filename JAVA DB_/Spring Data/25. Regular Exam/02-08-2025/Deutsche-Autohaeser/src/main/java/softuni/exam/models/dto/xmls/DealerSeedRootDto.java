package softuni.exam.models.dto.xmls;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "dealers")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealerSeedRootDto implements Serializable {

    @XmlElement(name = "dealer")
    private List<DealerSeedDto> dealers;

    public DealerSeedRootDto() {}

    public List<DealerSeedDto> getDealers() {
        return dealers;
    }

    public void setDealers(List<DealerSeedDto> dealers) {
        this.dealers = dealers;
    }
}