namespace DeskMarket.Models.Product
{
    using System.ComponentModel.DataAnnotations;

    using Microsoft.AspNetCore.Mvc.Rendering;

    using static DeskMarket.Common.Constants.ModelValidation.Common;
    using static DeskMarket.Common.Constants.ModelValidation.ProductValidation;

    public class ProductFormModel
    {
        [Required(ErrorMessage = RequiredError)]
        [StringLength(
            NameMaxLength,
            MinimumLength = NameMinLength,
            ErrorMessage = LengthError)]
        public string ProductName { get; init; } = null!;

        [Required(ErrorMessage = RequiredError)]
        [StringLength(
            DescriptionMaxLength,
            MinimumLength = DescriptionMinLength,
            ErrorMessage = LengthError)]
        public string Description { get; init; } = null!;

        [Range(PriceMinValue, PriceMaxValue, ErrorMessage = PriceError)]
        public decimal Price { get; init; }

        [StringLength(
            ImageUrlMaxLength,
            MinimumLength = ImageUrlMinLength,
            ErrorMessage = LengthError)]
        public string? ImageUrl { get; init; }

        public string AddedOn { get; init; } = null!;

        public int CategoryId { get; init; }

        public string? SellerId { get; init; } 

        public IEnumerable<SelectListItem> Categories { get; set; } = new List<SelectListItem>();
    }
}
