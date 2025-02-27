namespace DeskMarket.Data.Models
{
    using System.ComponentModel.DataAnnotations;

    using static DeskMarket.Data.Models.Constraints.ModelConstraints.CategoryConstraints;

    public class Category
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [MaxLength(NameMaxLength)]
        public string Name { get; set; } = null!;

        public ICollection<Product> Products { get; set; } = new List<Product>();
    }
}
