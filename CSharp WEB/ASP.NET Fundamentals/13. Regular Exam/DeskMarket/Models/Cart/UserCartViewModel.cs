namespace DeskMarket.Models.Cart
{
    public class UserCartViewModel
    {
        public int Id { get; set; }

        public string? ImageUrl { get; set; }

        public string ProductName { get; set; } = null!;

        public decimal Price { get; set; }
    }
}
