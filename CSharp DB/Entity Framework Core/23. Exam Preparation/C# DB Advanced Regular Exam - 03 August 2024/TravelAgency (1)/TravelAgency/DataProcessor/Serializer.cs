using System.Text;
using System.Xml.Serialization;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using TravelAgency.Data;
using TravelAgency.Data.Models.Enums;
using TravelAgency.DataProcessor.ExportDtos;

namespace TravelAgency.DataProcessor
{
    public class Serializer
    {
        public static string ExportGuidesWithSpanishLanguageWithAllTheirTourPackages(TravelAgencyContext context)
        {
            var guides = context.Guides
                .Where(g => g.Language == Language.Spanish)
                .Include(g => g.TourPackagesGuides)
                .ThenInclude(tpg => tpg.TourPackage)
                .ToArray()
                .Select(g => new ExportGuideDto
                {
                    FullName = g.FullName,
                    TourPackages = g.TourPackagesGuides
                        .Select(tpg => tpg.TourPackage)
                        .OrderByDescending(tp => tp.Price)
                        .ThenBy(tp => tp.PackageName)
                        .Select(tp => new ExportTourPackageDto
                        {
                            Name = tp.PackageName,
                            Description = tp.Description ?? string.Empty,
                            Price = tp.Price
                        })
                        .ToArray()
                })
                .OrderByDescending(g => g.TourPackages.Length)
                .ThenBy(g => g.FullName)
                .ToArray();

            ExportGuidesDto guidesDto = new ExportGuidesDto
            {
                Guides = guides
            };

            XmlSerializer xmlSerializer = new XmlSerializer(typeof(ExportGuidesDto));
            StringBuilder sb = new StringBuilder();
            using StringWriter writer = new StringWriter(sb);
            
            var namespaces = new XmlSerializerNamespaces();
            namespaces.Add(string.Empty, string.Empty);
            
            xmlSerializer.Serialize(writer, guidesDto, namespaces);

            return sb.ToString().TrimEnd();
        }

        public static string ExportCustomersThatHaveBookedHorseRidingTourPackage(TravelAgencyContext context)
        {
            var horseRidingTourPackage = context.TourPackages
                .FirstOrDefault(tp => tp.PackageName == "Horse Riding Tour");

            if (horseRidingTourPackage == null)
            {
                return "[]";
            }

            var customers = context.Customers
                .Where(c => c.Bookings.Any(b => b.TourPackageId == horseRidingTourPackage.Id))
                .Include(c => c.Bookings)
                .ThenInclude(b => b.TourPackage)
                .ToArray()
                .Select(c => new ExportCustomerDto
                {
                    FullName = c.FullName,
                    PhoneNumber = c.PhoneNumber,
                    Bookings = c.Bookings
                        .Where(b => b.TourPackage.PackageName == "Horse Riding Tour")
                        .OrderBy(b => b.BookingDate)
                        .Select(b => new ExportBookingDto
                        {
                            TourPackageName = b.TourPackage.PackageName,
                            Date = b.BookingDate.ToString("yyyy-MM-dd")
                        })
                        .ToArray()
                })
                .OrderByDescending(c => c.Bookings.Length)
                .ThenBy(c => c.FullName)
                .ToArray();

            return JsonConvert.SerializeObject(customers, Formatting.Indented);
        }
    }
}
