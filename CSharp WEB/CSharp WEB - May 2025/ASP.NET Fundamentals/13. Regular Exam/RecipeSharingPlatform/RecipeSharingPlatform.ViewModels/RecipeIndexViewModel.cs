namespace RecipeSharingPlatform.ViewModels
{
    public class RecipeIndexViewModel
    {
        public int Id { get; set; }
        public string Title { get; set; } = null!;
        public string Instructions { get; set; } = null!;
        public string? ImageUrl { get; set; }
        public string AuthorName { get; set; } = null!;
        public string AuthorId { get; set; } = null!;
        public string CreatedOn { get; set; } = null!;
        public string CategoryName { get; set; } = null!;
        public bool IsInFavorites { get; set; }
    }
} 