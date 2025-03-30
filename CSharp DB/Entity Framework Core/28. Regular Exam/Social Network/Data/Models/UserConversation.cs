using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SocialNetwork.Data.Models
{
    public class UserConversation
    {
        [Required]
        [ForeignKey(nameof(User))]
        public int UserId { get; set; }

        public virtual User User { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(Conversation))]
        public int ConversationId { get; set; }

        public virtual Conversation Conversation { get; set; } = null!;
    }
} 