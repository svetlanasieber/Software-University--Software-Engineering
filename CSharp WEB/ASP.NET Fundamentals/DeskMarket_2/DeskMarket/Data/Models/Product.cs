namespace DeskMarket.Data.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    using Microsoft.AspNetCore.Identity;

    using static DeskMarket.Data.Models.Constraints.ModelConstraints.ProductConstraints;

    public class Product
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [MaxLength(NameMaxLength)]
        public string ProductName { get; set; } = null!;

        [Required]
        [MaxLength(DescriptionMaxLength)]
        public string Description { get; set; } = null!;

        [Range(PriceMinValue, PriceMaxValue)]
        public decimal Price { get; set; }

        [MaxLength(ImageUrlMaxLength)]
        public string? ImageUrl { get; set; }

        [Required]
        [ForeignKey(nameof(Seller))]
        public string SellerId { get; set; } = null!;

        public IdentityUser Seller { get; set; } = null!;

        public DateTime AddedOn { get; set; }

        [ForeignKey(nameof(Category))]
        public int CategoryId { get; set; }

        public Category Category { get; set; } = null!;

        public bool IsDeleted { get; set; }

        public ICollection<ProductClient> ProductsClients { get; set; } = new List<ProductClient>();
    }
}
