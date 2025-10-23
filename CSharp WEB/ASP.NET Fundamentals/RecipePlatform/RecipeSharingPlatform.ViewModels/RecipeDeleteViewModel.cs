namespace RecipeSharingPlatform.ViewModels
{
    public class RecipeDeleteViewModel
    {
        public int Id { get; set; }
        public string Title { get; set; } = null!;
        public string Instructions { get; set; } = null!;
        public string? ImageUrl { get; set; }
        public string AuthorName { get; set; } = null!;
        public string CreatedOn { get; set; } = null!;
        public string CategoryName { get; set; } = null!;
    }
} 