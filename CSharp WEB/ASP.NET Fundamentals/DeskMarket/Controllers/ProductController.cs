using DeskMarket.Models;
using DeskMarket.Services.Contracts;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DeskMarket.Controllers
{
    public class ProductController : BaseController
    {
        private readonly IProductService productService;

        public ProductController(IProductService productService)
        {
            this.productService = productService;
        }

        [AllowAnonymous]
        public async Task<IActionResult> Index()
        {
            string? userId = GetUserId();
            var model = await productService.GetIndexProductsAsync(userId);

            return View(model);
        }

        [HttpGet]
        public async Task<IActionResult> Add()
        {
            var model = await productService.GetAddModelAsync();
            return View(model);
        }


        [HttpPost]
        public async Task<IActionResult> Add(ProductAddViewModel model)
        {
            if (!ModelState.IsValid)
            {
                model = await productService.GetAddModelAsync();
                return View(model);
            }

            string? userId = GetUserId();

            if (string.IsNullOrEmpty(userId))
            {
                return RedirectToAction("Login", "Account");
            }

            await productService.AddProductAsync(model, userId!);

            return RedirectToAction("Index");
        }

        [HttpGet]
        public async Task<IActionResult> Cart()
        {
            string? userId = GetUserId();

            if (string.IsNullOrEmpty(userId))
            {
                return RedirectToAction("Login", "Account");
            }

            var allAddedProducts = await productService.GetCartProductsAsync(userId);

            if (allAddedProducts == null)
            {
                return RedirectToAction("Index");
            }

            return View(allAddedProducts);
        }

        [HttpPost]
        public async Task<IActionResult> AddToCart(int id)
        {
            string? userId = GetUserId();

            if (string.IsNullOrEmpty(userId))
            {
                return RedirectToAction("Login", "Account");
            }

            var productToAdd = await productService.GetProductByIdAsync(id);
            if (productToAdd == null)
            {
                return BadRequest();
            }

            await productService.AddProductToCartAsync(productToAdd, userId);
            return RedirectToAction(nameof(Index));
        }

        [AllowAnonymous]
        public async Task<IActionResult> Details(int id)
        {
            string? userId = GetUserId();
            ProductDetailsViewModel product = await productService.GetProductDetailsAsync(id, userId);

            if (product == null)
            {
                if (User?.Identity?.IsAuthenticated == false)
                {
                    return RedirectToAction("Index", "Home");
                }
                return RedirectToAction("Index");
            }

            return View(product);
        }

        public async Task<IActionResult> RemoveFromCart(int id)
        {
            string? userId = GetUserId();

            if (string.IsNullOrEmpty(userId))
            {
                return RedirectToAction("Login", "Account");
            }

            await productService.RemoveProductFromCartAsync(id, userId);

            return RedirectToAction(nameof(Cart));
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int id)
        {
            ProductEditViewModel? modelToEdit = await productService.GetProductToEditAsync(id);

            if(modelToEdit == null)
            {
                return RedirectToAction("Index");
            }
            string userId = GetUserId();


            if (modelToEdit.SellerId != userId)
            {
                return RedirectToAction("Index");
            }

            return View(modelToEdit);
        }

        [HttpPost]
        public async Task<IActionResult> Edit(ProductEditViewModel model)
        {
            string userId = GetUserId();

            if (model.SellerId != userId)
            {
                return RedirectToAction("Index");
            }

            bool success = await productService.EditProductAsync(model);

            if (success)
            {
                return RedirectToAction("Details", "Product", new { id = model.Id });
            }
            else
            {
               return View(model);
            }
        }

        [HttpGet]
        public async Task<IActionResult> Delete(int id)
        {
            string userId = GetUserId();

            ProductDeleteViewModel? modelToDelete = await productService.GetProductToDeleteAsync(id, userId);

            if (modelToDelete == null)
            {
                return RedirectToAction("Index");
            }

            return View(modelToDelete);
        }

        [HttpPost]
        public async Task<IActionResult> Delete(ProductDeleteViewModel model)
        {
            string userId = GetUserId();

            if (model.SellerId != userId)
            {
                return RedirectToAction("Index");
            }

            var productToDelete = await productService.DeleteProductAsync(model.Id);

            return RedirectToAction("Index");
        }
    }
}
