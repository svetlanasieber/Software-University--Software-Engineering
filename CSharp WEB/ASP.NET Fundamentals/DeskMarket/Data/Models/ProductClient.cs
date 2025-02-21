using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DeskMarket.Data.Models
{
    public class ProductClient
    {
        [Required]
        public int ProductId { get; set; }

        [ForeignKey(nameof(ProductId))]
        public virtual Product Product { get; set; } = null!;
        
        [Required]
        public string ClientId { get; set; } = null!;

        [ForeignKey(nameof(ClientId))]
        public virtual IdentityUser Client { get; set; } = null!;
    }
}