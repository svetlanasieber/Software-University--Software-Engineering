using System.ComponentModel.DataAnnotations;

namespace SocialNetwork.Data.Models
{
    public class Conversation
    {
        public Conversation()
        {
            this.Messages = new HashSet<Message>();
            this.UsersConversations = new HashSet<UserConversation>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [MinLength(2)]
        [MaxLength(30)]
        public string Title { get; set; } = null!;

        [Required]
        public DateTime StartedAt { get; set; }

        public virtual ICollection<Message> Messages { get; set; }

        public virtual ICollection<UserConversation> UsersConversations { get; set; }
    }
} 