using DeskMarket.Common;
using System.ComponentModel.DataAnnotations;
using System.Configuration;

namespace DeskMarket.Models
{
    public class ProductAddViewModel
    {
        [Required]
        [StringLength(ValidationConstants.ProductNameMaxLength, MinimumLength =  ValidationConstants.ProductNameMinLength)]
        public string ProductName { get; set; } = null!;

        [Required]
        [StringLength(ValidationConstants.ProductDescriptionMaxLength, MinimumLength = ValidationConstants.ProductDescriptionMinLength)]
        public string Description { get; set; } = null!;

        [Required]
        [Range(typeof(decimal), ValidationConstants.ProductPriceMinValue, ValidationConstants.ProductPriceMaxValue)]
        public decimal Price { get; set; }

        public string? ImageUrl { get; set; }

        [Required]
        [RegexStringValidator(@"^\d{4}-\d{2}-\d{2}$")]
        public string AddedOn { get; set; } = null!;

        [Range(1, int.MaxValue)]
        public int CategoryId { get; set; }

        public virtual IEnumerable<CategoryViewModel>? Categories { get; set; }
    }
}
