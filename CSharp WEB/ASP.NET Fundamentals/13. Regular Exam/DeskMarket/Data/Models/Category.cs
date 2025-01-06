using System.ComponentModel.DataAnnotations;
using Microsoft.EntityFrameworkCore;
using static DeskMarket.Constants.CategoryConstants;

namespace DeskMarket.Data.Models
{
    public class Category
    {
        [Key]
        [Required]
        [Comment("The category unique identifier")]
        public int Id { get; set; }

        [Required]
        [StringLength(NameMaxLength, MinimumLength = NameMinLength, ErrorMessage = NameLengthErrorMessage)]
        [Comment("The name of the category")]
        public string Name { get; set; } = null!;

        [Comment("Collection of products")]
        public ICollection<Product> Products { get; set; } = new HashSet<Product>();
    }
}
