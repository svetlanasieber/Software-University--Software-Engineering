using System.Xml.Serialization;

namespace SocialNetwork.DataProcessor.ExportDTOs
{
    [XmlRoot("Users")]
    public class ExportUsersRootDto
    {
        [XmlElement("User")]
        public ExportUserDto[] Users { get; set; } = null!;
    }
} 