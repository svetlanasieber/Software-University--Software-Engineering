namespace DeskMarket.Data.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    using Microsoft.AspNetCore.Identity;
    using Microsoft.EntityFrameworkCore;

    [PrimaryKey(nameof(ProductId), nameof(ClientId))]
    public class ProductClient
    {
        [ForeignKey(nameof(Product))]
        public int ProductId { get; set; }

        [DeleteBehavior(DeleteBehavior.NoAction)]
        public Product Product { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(Client))]
        public string ClientId { get; set; } = null!;

        [DeleteBehavior(DeleteBehavior.NoAction)]
        public IdentityUser Client { get; set; } = null!;
    }
}
