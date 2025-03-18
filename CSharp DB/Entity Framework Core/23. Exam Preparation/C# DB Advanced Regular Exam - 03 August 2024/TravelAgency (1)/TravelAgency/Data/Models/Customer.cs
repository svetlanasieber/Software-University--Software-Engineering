using System.ComponentModel.DataAnnotations;

namespace TravelAgency.Data.Models
{
    public class Customer
    {
        public Customer()
        {
            this.Bookings = new HashSet<Booking>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(60, MinimumLength = 4)]
        public string FullName { get; set; } = null!;

        [Required]
        [StringLength(50, MinimumLength = 6)]
        public string Email { get; set; } = null!;

        [Required]
        [StringLength(13, MinimumLength = 13)]
        [RegularExpression(@"^\+\d{12}$")]
        public string PhoneNumber { get; set; } = null!;

        public virtual ICollection<Booking> Bookings { get; set; }
    }
} 