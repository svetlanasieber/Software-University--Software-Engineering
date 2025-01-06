using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DeskMarket.Data.Models
{
    public class ProductClient
    {
        public int ProductId { get; set; }

        [Required]
        [ForeignKey(nameof(ProductId))]
        public Product Product { get; set; } = null!;

        [Required]
        public string ClientId { get; set; } = null!;

        [Required]
        [ForeignKey(nameof(ClientId))]
        public IdentityUser Client { get; set; } = null!;

        public bool IsDeleted { get; set; }
    }
}
