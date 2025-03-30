namespace SocialNetwork.DataProcessor.ExportDTOs
{
    public class ExportMessageDto
    {
        public string Content { get; set; } = null!;
        
        public string SentAt { get; set; } = null!;
        
        public int Status { get; set; }
        
        public string SenderUsername { get; set; } = null!;
    }
} 