using Newtonsoft.Json;

namespace TravelAgency.DataProcessor.ExportDtos
{
    public class ExportCustomerDto
    {
        [JsonProperty("FullName")]
        public string FullName { get; set; } = null!;

        [JsonProperty("PhoneNumber")]
        public string PhoneNumber { get; set; } = null!;

        [JsonProperty("Bookings")]
        public ExportBookingDto[] Bookings { get; set; } = null!;
    }
} 