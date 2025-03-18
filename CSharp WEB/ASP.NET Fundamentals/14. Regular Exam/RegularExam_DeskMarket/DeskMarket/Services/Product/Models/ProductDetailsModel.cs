namespace DeskMarket.Services.Product.Models
{
    public class ProductDetailsModel : ProductServiceModel
    {
        public string CategoryName { get; init; } = null!;

        public string Seller { get; init; } = null!;

        public bool HasBought { get; set; } 
    }
}
