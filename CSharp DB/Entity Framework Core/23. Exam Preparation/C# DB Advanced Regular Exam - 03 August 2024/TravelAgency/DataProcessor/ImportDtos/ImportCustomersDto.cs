using System.Xml.Serialization;

namespace TravelAgency.DataProcessor.ImportDtos
{
    [XmlRoot("Customers")]
    public class ImportCustomersDto
    {
        [XmlElement("Customer")]
        public ImportCustomerDto[] Customers { get; set; } = null!;
    }
} 