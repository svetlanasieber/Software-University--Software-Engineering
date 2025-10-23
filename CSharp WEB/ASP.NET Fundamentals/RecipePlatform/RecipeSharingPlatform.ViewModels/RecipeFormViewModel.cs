using System.ComponentModel.DataAnnotations;
using RecipeSharingPlatform.GCommon;

namespace RecipeSharingPlatform.ViewModels
{
    public class RecipeFormViewModel
    {
        [Required]
        [StringLength(ValidationConstants.RecipeTitleMaxLength, 
            MinimumLength = ValidationConstants.RecipeTitleMinLength)]
        public string Title { get; set; } = null!;

        [Required]
        [StringLength(ValidationConstants.RecipeInstructionsMaxLength, 
            MinimumLength = ValidationConstants.RecipeInstructionsMinLength)]
        public string Instructions { get; set; } = null!;

        [Display(Name = "Image URL")]
        public string? ImageUrl { get; set; }

        [Required]
        [Display(Name = "Category")]
        public int CategoryId { get; set; }

        [Display(Name = "Created On")]
        [DataType(DataType.Date)]
        public DateTime? CreatedOn { get; set; }

        public List<CategoryViewModel> Categories { get; set; } = new List<CategoryViewModel>();
    }
} 