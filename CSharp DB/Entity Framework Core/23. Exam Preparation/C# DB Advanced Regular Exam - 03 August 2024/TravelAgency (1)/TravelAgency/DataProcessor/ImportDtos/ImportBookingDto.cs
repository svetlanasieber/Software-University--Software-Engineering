using System.ComponentModel.DataAnnotations;
using Newtonsoft.Json;

namespace TravelAgency.DataProcessor.ImportDtos
{
    public class ImportBookingDto
    {
        [JsonProperty("BookingDate")]
        [Required]
        public string BookingDate { get; set; } = null!;

        [JsonProperty("CustomerName")]
        [Required]
        public string CustomerName { get; set; } = null!;

        [JsonProperty("TourPackageName")]
        [Required]
        public string TourPackageName { get; set; } = null!;
    }
} 