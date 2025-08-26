using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.AspNetCore.Identity;
using RecipeSharingPlatform.GCommon;

namespace RecipeSharingPlatform.Data.Models
{
    public class Recipe
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(ValidationConstants.RecipeTitleMaxLength, 
            MinimumLength = ValidationConstants.RecipeTitleMinLength)]
        public string Title { get; set; } = null!;

        [Required]
        [StringLength(ValidationConstants.RecipeInstructionsMaxLength, 
            MinimumLength = ValidationConstants.RecipeInstructionsMinLength)]
        public string Instructions { get; set; } = null!;

        public string? ImageUrl { get; set; }

        [Required]
        public string AuthorId { get; set; } = null!;

        [ForeignKey(nameof(AuthorId))]
        public virtual IdentityUser Author { get; set; } = null!;

        [Required]
        public DateTime CreatedOn { get; set; }

        [Required]
        public int CategoryId { get; set; }

        [ForeignKey(nameof(CategoryId))]
        public virtual Category Category { get; set; } = null!;

        public bool IsDeleted { get; set; } = false;

        public virtual ICollection<UserRecipe> UsersRecipes { get; set; } = new List<UserRecipe>();
    }
} 