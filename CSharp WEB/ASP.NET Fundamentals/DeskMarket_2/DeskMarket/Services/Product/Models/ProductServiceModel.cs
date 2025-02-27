namespace DeskMarket.Services.Product.Models
{
    public class ProductServiceModel
    {
        public int Id { get; set; }

        public string ProductName { get; init; } = null!;

        public string Description { get; init; } = null!;

        public decimal Price { get; init; }

        public string? ImageUrl { get; init; }

        public string SellerId { get; set; } = null!;

        public DateTime AddedOn { get; init; }

        public int CategoryId { get; init; }

        public bool IsDeleted { get; init; }
    }
}
