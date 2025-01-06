using System.ComponentModel.DataAnnotations;
using static DeskMarket.Constants.ProductConstants;

namespace DeskMarket.Models.Product
{
    public class ProductInputViewModel
    {
        [Required]
        [StringLength(ProductNameMaxLength, MinimumLength = ProductNameMinLength, ErrorMessage = ProductNameNameLengthErrorMessage)]
        public string ProductName { get; set; } = string.Empty;

        [Range(PriceRangeLowestValue, PriceRangeHighestValue, ErrorMessage = PriceRangeErrorMessage)]
        public decimal Price { get; set; }

        [Required]
        [StringLength(DescriptionMaxLength, MinimumLength = DescriptionMinLength, ErrorMessage = DescriptionLengthErrorMessage)]
        public string Description { get; set; } = string.Empty;

        public string? ImageUrl { get; set; }

        public string AddedOn { get; set; } = DateTime.Now.ToString(DateTimeFormat);

        public int CategoryId { get; set; }

        public IEnumerable<CategorySelectList> Categories = new HashSet<CategorySelectList>();
    }
}
