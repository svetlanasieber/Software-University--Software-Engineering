using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SocialNetwork.Data.Models
{
    public class Friendship
    {
        [Required]
        [ForeignKey(nameof(UserOne))]
        public int UserOneId { get; set; }

        public virtual User UserOne { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(UserTwo))]
        public int UserTwoId { get; set; }

        public virtual User UserTwo { get; set; } = null!;
    }
} 