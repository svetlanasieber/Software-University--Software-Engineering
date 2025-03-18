using System.Xml.Serialization;

namespace TravelAgency.DataProcessor.ExportDtos
{
    [XmlType("Guides")]
    [XmlRoot("Guides")]
    public class ExportGuidesDto
    {
        [XmlElement("Guide")]
        public ExportGuideDto[] Guides { get; set; } = null!;
    }
} 