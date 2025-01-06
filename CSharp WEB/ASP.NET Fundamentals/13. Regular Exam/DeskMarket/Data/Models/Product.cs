using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using static DeskMarket.Constants.ProductConstants;

namespace DeskMarket.Data.Models
{
    public class Product
    {
        [Key]
        [Required]
        [Comment("The product unique identifier")]
        public int Id { get; set; }

        [Required]
        [StringLength(ProductNameMaxLength, MinimumLength = ProductNameMinLength, ErrorMessage = ProductNameNameLengthErrorMessage)]
        [Comment("The name of the product")]
        public string ProductName { get; set; } = null!;

        [Required]
        [StringLength(DescriptionMaxLength, MinimumLength = DescriptionMinLength, ErrorMessage = DescriptionLengthErrorMessage)]
        [Comment("The description of the product")]
        public string Description { get; set; } = null!;

        [Range(PriceRangeLowestValue, PriceRangeHighestValue, ErrorMessage = PriceRangeErrorMessage)]
        [Precision(18, 2)]
        [Comment("The price of the product")]
        public decimal Price { get; set; }

        [Comment("The product ImageUrl")]
        public string? ImageUrl { get; set; }

        [Comment("The date and time when the product is created")]
        public DateTime AddedOn { get; set; }

        [Required]
        [Comment("The seller of the product")]
        public string SellerId { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(SellerId))]
        public IdentityUser Seller { get; set; } = null!;

        [Comment("The category of the product")]
        public int CategoryId { get; set; }

        [Required]
        [ForeignKey(nameof(CategoryId))]
        public Category Category { get; set; } = null!;

        public bool IsDeleted { get; set; }

        //public ICollection<ProductClient> ProductsClients { get; set; } = new HashSet<ProductClient>();
    }
}
