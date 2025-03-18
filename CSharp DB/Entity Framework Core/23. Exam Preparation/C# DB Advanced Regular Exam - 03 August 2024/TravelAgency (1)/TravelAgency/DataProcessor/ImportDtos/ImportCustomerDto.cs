using System.ComponentModel.DataAnnotations;
using System.Xml.Serialization;

namespace TravelAgency.DataProcessor.ImportDtos
{
    [XmlType("Customer")]
    public class ImportCustomerDto
    {
        [XmlAttribute("phoneNumber")]
        [Required]
        [StringLength(13, MinimumLength = 13)]
        [RegularExpression(@"^\+\d{12}$")]
        public string PhoneNumber { get; set; } = null!;

        [XmlElement("FullName")]
        [Required]
        [StringLength(60, MinimumLength = 4)]
        public string FullName { get; set; } = null!;

        [XmlElement("Email")]
        [Required]
        [StringLength(50, MinimumLength = 6)]
        public string Email { get; set; } = null!;
    }
} 