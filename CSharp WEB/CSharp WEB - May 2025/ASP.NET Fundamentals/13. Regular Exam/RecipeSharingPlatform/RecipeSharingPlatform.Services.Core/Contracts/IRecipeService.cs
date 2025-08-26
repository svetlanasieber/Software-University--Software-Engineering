using RecipeSharingPlatform.ViewModels;

namespace RecipeSharingPlatform.Services.Core.Contracts
{
    public interface IRecipeService
    {
        Task<IEnumerable<RecipeIndexViewModel>> GetAllRecipesAsync(string? userId = null);
        Task<RecipeDetailsViewModel?> GetRecipeDetailsAsync(int id, string? userId = null);
        Task<int> CreateRecipeAsync(RecipeFormViewModel model, string authorId);
        Task<RecipeFormViewModel?> GetRecipeForEditAsync(int id, string userId);
        Task<bool> UpdateRecipeAsync(int id, RecipeFormViewModel model, string userId);
        Task<RecipeDeleteViewModel?> GetRecipeForDeleteAsync(int id, string userId);
        Task<bool> DeleteRecipeAsync(int id, string userId);
        Task<bool> AddToFavoritesAsync(int recipeId, string userId);
        Task<bool> RemoveFromFavoritesAsync(int recipeId, string userId);
        Task<IEnumerable<RecipeIndexViewModel>> GetUserFavoritesAsync(string userId);
        Task<IEnumerable<CategoryViewModel>> GetAllCategoriesAsync();
        Task<bool> IsRecipeInUserFavoritesAsync(int recipeId, string userId);
        Task<bool> IsUserAuthorOfRecipeAsync(int recipeId, string userId);
    }
}
