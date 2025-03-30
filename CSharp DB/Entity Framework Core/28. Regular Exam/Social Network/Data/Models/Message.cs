using SocialNetwork.Data.Models.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SocialNetwork.Data.Models
{
    public class Message
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [MinLength(1)]
        [MaxLength(200)]
        public string Content { get; set; } = null!;

        [Required]
        public DateTime SentAt { get; set; }

        [Required]
        public MessageStatus Status { get; set; }

        [Required]
        [ForeignKey(nameof(Conversation))]
        public int ConversationId { get; set; }

        public virtual Conversation Conversation { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(Sender))]
        public int SenderId { get; set; }

        public virtual User Sender { get; set; } = null!;
    }
} 