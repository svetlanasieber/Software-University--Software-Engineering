using System.Xml.Serialization;

namespace TravelAgency.DataProcessor.ExportDtos
{
    [XmlType("TourPackage")]
    public class ExportTourPackageDto
    {
        [XmlElement("n")]
        public string Name { get; set; } = null!;

        [XmlElement("Description")]
        public string Description { get; set; } = null!;

        [XmlElement("Price")]
        public decimal Price { get; set; }
    }
} 