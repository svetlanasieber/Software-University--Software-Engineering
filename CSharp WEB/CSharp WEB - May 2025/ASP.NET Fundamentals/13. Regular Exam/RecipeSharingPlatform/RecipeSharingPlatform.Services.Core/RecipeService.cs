using Microsoft.EntityFrameworkCore;
using RecipeSharingPlatform.Data;
using RecipeSharingPlatform.Data.Models;
using RecipeSharingPlatform.Services.Core.Contracts;
using RecipeSharingPlatform.ViewModels;

namespace RecipeSharingPlatform.Services.Core
{
    public class RecipeService : IRecipeService
    {
        private readonly ApplicationDbContext _context;

        public RecipeService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<RecipeIndexViewModel>> GetAllRecipesAsync(string? userId = null)
        {
            var recipes = await _context.Recipes
                .Include(r => r.Author)
                .Include(r => r.Category)
                .Include(r => r.UsersRecipes)
                .Where(r => !r.IsDeleted)
                .Select(r => new RecipeIndexViewModel
                {
                    Id = r.Id,
                    Title = r.Title,
                    Instructions = r.Instructions,
                    ImageUrl = r.ImageUrl,
                    AuthorName = r.Author.UserName ?? r.Author.Email ?? "Unknown",
                    AuthorId = r.AuthorId,
                    CreatedOn = r.CreatedOn.ToString("dd-MM-yyyy"),
                    CategoryName = r.Category.Name,
                    IsInFavorites = userId != null && r.UsersRecipes.Any(ur => ur.UserId == userId)
                })
                .ToListAsync();

            return recipes;
        }

        public async Task<RecipeDetailsViewModel?> GetRecipeDetailsAsync(int id, string? userId = null)
        {
            var recipe = await _context.Recipes
                .Include(r => r.Author)
                .Include(r => r.Category)
                .Include(r => r.UsersRecipes)
                .Where(r => r.Id == id && !r.IsDeleted)
                .Select(r => new RecipeDetailsViewModel
                {
                    Id = r.Id,
                    Title = r.Title,
                    Instructions = r.Instructions,
                    ImageUrl = r.ImageUrl,
                    AuthorName = r.Author.UserName ?? r.Author.Email ?? "Unknown",
                    AuthorId = r.AuthorId,
                    CreatedOn = r.CreatedOn.ToString("dd-MM-yyyy"),
                    CategoryName = r.Category.Name,
                    IsInFavorites = userId != null && r.UsersRecipes.Any(ur => ur.UserId == userId),
                    IsAuthor = userId != null && r.AuthorId == userId
                })
                .FirstOrDefaultAsync();

            return recipe;
        }

        public async Task<int> CreateRecipeAsync(RecipeFormViewModel model, string authorId)
        {
            var recipe = new Recipe
            {
                Title = model.Title,
                Instructions = model.Instructions,
                ImageUrl = model.ImageUrl,
                AuthorId = authorId,
                CreatedOn = model.CreatedOn ?? DateTime.Now,
                CategoryId = model.CategoryId,
                IsDeleted = false
            };

            _context.Recipes.Add(recipe);
            await _context.SaveChangesAsync();
            return recipe.Id;
        }

        public async Task<RecipeFormViewModel?> GetRecipeForEditAsync(int id, string userId)
        {
            var recipe = await _context.Recipes
                .Include(r => r.Category)
                .Where(r => r.Id == id && r.AuthorId == userId && !r.IsDeleted)
                .FirstOrDefaultAsync();

            if (recipe == null)
                return null;

            var categories = await GetAllCategoriesAsync();

            return new RecipeFormViewModel
            {
                Title = recipe.Title,
                Instructions = recipe.Instructions,
                ImageUrl = recipe.ImageUrl,
                CategoryId = recipe.CategoryId,
                CreatedOn = recipe.CreatedOn,
                Categories = categories.ToList()
            };
        }

        public async Task<bool> UpdateRecipeAsync(int id, RecipeFormViewModel model, string userId)
        {
            var recipe = await _context.Recipes
                .Where(r => r.Id == id && r.AuthorId == userId && !r.IsDeleted)
                .FirstOrDefaultAsync();

            if (recipe == null)
                return false;

            recipe.Title = model.Title;
            recipe.Instructions = model.Instructions;
            recipe.ImageUrl = model.ImageUrl;
            recipe.CategoryId = model.CategoryId;
            if (model.CreatedOn.HasValue)
                recipe.CreatedOn = model.CreatedOn.Value;

            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<RecipeDeleteViewModel?> GetRecipeForDeleteAsync(int id, string userId)
        {
            var recipe = await _context.Recipes
                .Include(r => r.Author)
                .Include(r => r.Category)
                .Where(r => r.Id == id && r.AuthorId == userId && !r.IsDeleted)
                .Select(r => new RecipeDeleteViewModel
                {
                    Id = r.Id,
                    Title = r.Title,
                    Instructions = r.Instructions,
                    ImageUrl = r.ImageUrl,
                    AuthorName = r.Author.UserName ?? r.Author.Email ?? "Unknown",
                    CreatedOn = r.CreatedOn.ToString("dd-MM-yyyy"),
                    CategoryName = r.Category.Name
                })
                .FirstOrDefaultAsync();

            return recipe;
        }

        public async Task<bool> DeleteRecipeAsync(int id, string userId)
        {
            var recipe = await _context.Recipes
                .Where(r => r.Id == id && r.AuthorId == userId && !r.IsDeleted)
                .FirstOrDefaultAsync();

            if (recipe == null)
                return false;

            recipe.IsDeleted = true;
            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<bool> AddToFavoritesAsync(int recipeId, string userId)
        {
            var recipe = await _context.Recipes
                .Where(r => r.Id == recipeId && !r.IsDeleted)
                .FirstOrDefaultAsync();

            if (recipe == null || recipe.AuthorId == userId)
                return false;

            var existingFavorite = await _context.UsersRecipes
                .Where(ur => ur.UserId == userId && ur.RecipeId == recipeId)
                .FirstOrDefaultAsync();

            if (existingFavorite != null)
                return false;

            var userRecipe = new UserRecipe
            {
                UserId = userId,
                RecipeId = recipeId
            };

            _context.UsersRecipes.Add(userRecipe);
            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<bool> RemoveFromFavoritesAsync(int recipeId, string userId)
        {
            var userRecipe = await _context.UsersRecipes
                .Where(ur => ur.UserId == userId && ur.RecipeId == recipeId)
                .FirstOrDefaultAsync();

            if (userRecipe == null)
                return false;

            _context.UsersRecipes.Remove(userRecipe);
            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<IEnumerable<RecipeIndexViewModel>> GetUserFavoritesAsync(string userId)
        {
            var favorites = await _context.UsersRecipes
                .Include(ur => ur.Recipe)
                .ThenInclude(r => r.Author)
                .Include(ur => ur.Recipe)
                .ThenInclude(r => r.Category)
                .Where(ur => ur.UserId == userId && !ur.Recipe.IsDeleted)
                .Select(ur => new RecipeIndexViewModel
                {
                    Id = ur.Recipe.Id,
                    Title = ur.Recipe.Title,
                    Instructions = ur.Recipe.Instructions,
                    ImageUrl = ur.Recipe.ImageUrl,
                    AuthorName = ur.Recipe.Author.UserName ?? ur.Recipe.Author.Email ?? "Unknown",
                    AuthorId = ur.Recipe.AuthorId,
                    CreatedOn = ur.Recipe.CreatedOn.ToString("dd-MM-yyyy"),
                    CategoryName = ur.Recipe.Category.Name,
                    IsInFavorites = true
                })
                .ToListAsync();

            return favorites;
        }

        public async Task<IEnumerable<CategoryViewModel>> GetAllCategoriesAsync()
        {
            var categories = await _context.Categories
                .Select(c => new CategoryViewModel
                {
                    Id = c.Id,
                    Name = c.Name
                })
                .ToListAsync();

            return categories;
        }

        public async Task<bool> IsRecipeInUserFavoritesAsync(int recipeId, string userId)
        {
            return await _context.UsersRecipes
                .AnyAsync(ur => ur.UserId == userId && ur.RecipeId == recipeId);
        }

        public async Task<bool> IsUserAuthorOfRecipeAsync(int recipeId, string userId)
        {
            return await _context.Recipes
                .AnyAsync(r => r.Id == recipeId && r.AuthorId == userId && !r.IsDeleted);
        }
    }
}
