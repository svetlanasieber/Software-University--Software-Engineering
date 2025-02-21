using DeskMarket.Common;
using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;

namespace DeskMarket.Data.Models
{
    public class Product
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(ValidationConstants.ProductNameMaxLength)]
        public string ProductName { get; set; } = null!;

        [Required]
        [StringLength(ValidationConstants.ProductDescriptionMaxLength)]
        public string Description { get; set; } = null!;

        [Required]
        [Range(typeof(decimal), ValidationConstants.ProductPriceMinValue, ValidationConstants.ProductPriceMaxValue)]
        public decimal Price { get; set; }

        public string? ImageUrl { get; set; }

        [Required]
        public string SellerId { get; set; } = null!;

        [Required]
        public IdentityUser Seller { get; set; } = null!;

        [Required]
        public DateTime AddedOn { get; set; }

        [Required]
        public int CategoryId { get; set; }

        [Required]
        public Category Category { get; set; } = null!;

        [Required]
        public bool IsDeleted { get; set; }

        public virtual ICollection<ProductClient> ProductsClients { get; set; } = new HashSet<ProductClient>();
    }
}
