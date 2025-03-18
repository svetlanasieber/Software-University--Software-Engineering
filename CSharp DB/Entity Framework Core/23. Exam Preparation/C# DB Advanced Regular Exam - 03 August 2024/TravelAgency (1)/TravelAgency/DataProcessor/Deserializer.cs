using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Text;
using System.Xml.Serialization;
using Newtonsoft.Json;
using TravelAgency.Data;
using TravelAgency.Data.Models;
using TravelAgency.DataProcessor.ImportDtos;

namespace TravelAgency.DataProcessor
{
    public class Deserializer
    {
        private const string ErrorMessage = "Invalid data format!";
        private const string DuplicationDataMessage = "Error! Data duplicated.";
        private const string SuccessfullyImportedCustomer = "Successfully imported customer - {0}";
        private const string SuccessfullyImportedBooking = "Successfully imported booking. TourPackage: {0}, Date: {1}";

        public static string ImportCustomers(TravelAgencyContext context, string xmlString)
        {
            StringBuilder sb = new StringBuilder();

            XmlSerializer xmlSerializer = new XmlSerializer(typeof(ImportCustomersDto));
            using StringReader stringReader = new StringReader(xmlString);
            ImportCustomersDto customersDto = (ImportCustomersDto)xmlSerializer.Deserialize(stringReader);

            List<Customer> validCustomers = new List<Customer>();

            foreach (var customerDto in customersDto.Customers)
            {
                if (!IsValid(customerDto))
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                // Check for duplicates
                if (validCustomers.Any(c => c.FullName == customerDto.FullName || 
                                           c.Email == customerDto.Email || 
                                           c.PhoneNumber == customerDto.PhoneNumber) ||
                    context.Customers.Any(c => c.FullName == customerDto.FullName || 
                                              c.Email == customerDto.Email || 
                                              c.PhoneNumber == customerDto.PhoneNumber))
                {
                    sb.AppendLine(DuplicationDataMessage);
                    continue;
                }

                Customer customer = new Customer
                {
                    FullName = customerDto.FullName,
                    Email = customerDto.Email,
                    PhoneNumber = customerDto.PhoneNumber
                };

                validCustomers.Add(customer);
                sb.AppendLine(string.Format(SuccessfullyImportedCustomer, customer.FullName));
            }

            context.Customers.AddRange(validCustomers);
            context.SaveChanges();

            return sb.ToString().TrimEnd();
        }

        public static string ImportBookings(TravelAgencyContext context, string jsonString)
        {
            StringBuilder sb = new StringBuilder();

            ImportBookingDto[] bookingDtos = JsonConvert.DeserializeObject<ImportBookingDto[]>(jsonString);

            List<Booking> validBookings = new List<Booking>();

            foreach (var bookingDto in bookingDtos)
            {
                if (!IsValid(bookingDto))
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                // Parse date
                DateTime bookingDate;
                bool isValidDate = DateTime.TryParseExact(
                    bookingDto.BookingDate,
                    "yyyy-MM-dd",
                    CultureInfo.InvariantCulture,
                    DateTimeStyles.None,
                    out bookingDate);

                if (!isValidDate)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                // Find customer
                Customer customer = context.Customers
                    .FirstOrDefault(c => c.FullName == bookingDto.CustomerName);

                if (customer == null)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                // Find tour package
                TourPackage tourPackage = context.TourPackages
                    .FirstOrDefault(tp => tp.PackageName == bookingDto.TourPackageName);

                if (tourPackage == null)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                Booking booking = new Booking
                {
                    BookingDate = bookingDate,
                    CustomerId = customer.Id,
                    TourPackageId = tourPackage.Id
                };

                validBookings.Add(booking);
                sb.AppendLine(string.Format(SuccessfullyImportedBooking, tourPackage.PackageName, bookingDate.ToString("yyyy-MM-dd")));
            }

            context.Bookings.AddRange(validBookings);
            context.SaveChanges();

            return sb.ToString().TrimEnd();
        }

        public static bool IsValid(object dto)
        {
            var validateContext = new ValidationContext(dto);
            var validationResults = new List<ValidationResult>();

            bool isValid = Validator.TryValidateObject(dto, validateContext, validationResults, true);

            return isValid;
        }
    }
}
