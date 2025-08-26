using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using RecipeSharingPlatform.Services.Core.Contracts;
using RecipeSharingPlatform.ViewModels;
using System.Security.Claims;

namespace RecipeSharingPlatform.Web.Controllers
{
    public class RecipeController : Controller
    {
        private readonly IRecipeService _recipeService;

        public RecipeController(IRecipeService recipeService)
        {
            _recipeService = recipeService;
        }

        public async Task<IActionResult> Index()
        {
            var userId = User?.FindFirstValue(ClaimTypes.NameIdentifier);
            var recipes = await _recipeService.GetAllRecipesAsync(userId);
            return View(recipes);
        }

        public async Task<IActionResult> Details(int id)
        {
            var userId = User?.FindFirstValue(ClaimTypes.NameIdentifier);
            var recipe = await _recipeService.GetRecipeDetailsAsync(id, userId);
            
            if (recipe == null)
            {
                return NotFound();
            }

            return View(recipe);
        }

        [Authorize]
        public async Task<IActionResult> Create()
        {
            var categories = await _recipeService.GetAllCategoriesAsync();
            var model = new RecipeFormViewModel
            {
                Categories = categories.ToList(),
                CreatedOn = DateTime.Now
            };
            return View(model);
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(RecipeFormViewModel model)
        {
            if (!ModelState.IsValid)
            {
                model.Categories = (await _recipeService.GetAllCategoriesAsync()).ToList();
                return View(model);
            }

            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            await _recipeService.CreateRecipeAsync(model, userId);
            return RedirectToAction(nameof(Index));
        }

        [Authorize]
        public async Task<IActionResult> Edit(int id)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            var model = await _recipeService.GetRecipeForEditAsync(id, userId);
            
            if (model == null)
            {
                return NotFound();
            }

            return View(model);
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, RecipeFormViewModel model)
        {
            if (!ModelState.IsValid)
            {
                model.Categories = (await _recipeService.GetAllCategoriesAsync()).ToList();
                return View(model);
            }

            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            var success = await _recipeService.UpdateRecipeAsync(id, model, userId);
            
            if (!success)
            {
                return NotFound();
            }

            return RedirectToAction(nameof(Details), new { id = id });
        }

        [Authorize]
        public async Task<IActionResult> Delete(int id)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            var model = await _recipeService.GetRecipeForDeleteAsync(id, userId);
            
            if (model == null)
            {
                return NotFound();
            }

            return View(model);
        }

        [HttpPost, ActionName("ConfirmDelete")]
        [Authorize]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> ConfirmDelete(int id)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            var success = await _recipeService.DeleteRecipeAsync(id, userId);
            
            if (!success)
            {
                return NotFound();
            }

            return RedirectToAction(nameof(Index));
        }

        [Authorize]
        public async Task<IActionResult> Save(int id)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            await _recipeService.AddToFavoritesAsync(id, userId);
            
            var returnUrl = Request.Headers["Referer"].ToString();
            if (!string.IsNullOrEmpty(returnUrl) && Url.IsLocalUrl(returnUrl))
            {
                return Redirect(returnUrl);
            }
            
            return RedirectToAction(nameof(Index));
        }

        [Authorize]
        public async Task<IActionResult> Remove(int id)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            await _recipeService.RemoveFromFavoritesAsync(id, userId);
            return RedirectToAction(nameof(Favorites));
        }

        [Authorize]
        public async Task<IActionResult> Favorites()
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier)!;
            var favorites = await _recipeService.GetUserFavoritesAsync(userId);
            return View(favorites);
        }
    }
} 