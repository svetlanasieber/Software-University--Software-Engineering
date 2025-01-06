namespace DeskMarket.Models.Product
{
    public class ProductDeleteViewModel
    {
        public int Id { get; set; }
        public string ProductName { get; set; } = null!;

        public string Seller { get; set; } = null!;

        public string SellerId { get; set; } = null!;
    }
}
