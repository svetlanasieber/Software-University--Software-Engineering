using System.Xml.Serialization;

namespace SocialNetwork.DataProcessor.ImportDTOs
{
    [XmlRoot("Messages")]
    public class ImportMessagesRootDto
    {
        [XmlElement("Message")]
        public ImportMessageDto[] Messages { get; set; } = null!;
    }
} 