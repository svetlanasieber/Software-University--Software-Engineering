using System.ComponentModel.DataAnnotations;

namespace TravelAgency.Data.Models
{
    public class TourPackage
    {
        public TourPackage()
        {
            this.Bookings = new HashSet<Booking>();
            this.TourPackagesGuides = new HashSet<TourPackageGuide>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(40, MinimumLength = 2)]
        public string PackageName { get; set; } = null!;

        [StringLength(200)]
        public string? Description { get; set; }

        [Required]
        [Range(0.01, double.MaxValue)]
        public decimal Price { get; set; }

        public virtual ICollection<Booking> Bookings { get; set; }

        public virtual ICollection<TourPackageGuide> TourPackagesGuides { get; set; }
    }
} 