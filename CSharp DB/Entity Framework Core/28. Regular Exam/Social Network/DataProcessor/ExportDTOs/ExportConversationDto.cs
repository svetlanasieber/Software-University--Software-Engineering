namespace SocialNetwork.DataProcessor.ExportDTOs
{
    public class ExportConversationDto
    {
        public int Id { get; set; }
        
        public string Title { get; set; } = null!;
        
        public string StartedAt { get; set; } = null!;
        
        public ExportMessageDto[] Messages { get; set; } = null!;
    }
} 