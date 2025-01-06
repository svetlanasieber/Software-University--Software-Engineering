using System.Globalization;
using System.Security.Claims;
using DeskMarket.Data;
using DeskMarket.Data.Models;
using DeskMarket.Models.Cart;
using DeskMarket.Models.Product;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using static DeskMarket.Constants.ProductConstants;

namespace DeskMarket.Controllers
{
    [Authorize]
    public class ProductController(ApplicationDbContext context) : Controller
    {
        private readonly ApplicationDbContext _context = context;

        [AllowAnonymous]
        [HttpGet]
        public async Task<IActionResult> Index()
        {
            string userId = GetUserId();

            IEnumerable<ProductIndexViewModel> products = await _context
                .Products
                .Where(p => p.IsDeleted == false)
                .AsNoTracking()
                .Select(p => new ProductIndexViewModel()
                {
                    Id = p.Id,
                    ImageUrl = p.ImageUrl,
                    ProductName = p.ProductName,
                    Price = p.Price,
                    IsSeller = (userId == p.SellerId),
                }).ToListAsync();

            IEnumerable<int> boughtProductIds = await _context
                .ProductsClients
                .AsNoTracking()
                .Where(pc => pc.ClientId == userId && pc.IsDeleted == false)
                .Select(pc => pc.ProductId)
                .ToListAsync();

            foreach (var p in products)
            {
                p.HasBought = boughtProductIds.Contains(p.Id);
            }

            return View(products);
        }

        [AllowAnonymous]
        [HttpGet]
        public async Task<IActionResult> Details(int id)
        {
            string userId = GetUserId();

            Product? product = await _context
                .Products
                .AsNoTracking()
                .Include(p => p.Category)
                .Include(p => p.Seller)
                .FirstOrDefaultAsync(p => p.Id == id && p.IsDeleted == false);

            if (product == null)
            {
                return RedirectToAction(nameof(Index));
            }

            ProductDetailsViewModel model = new ProductDetailsViewModel()
            {
                Id = product.Id,
                ImageUrl = product.ImageUrl,
                ProductName = product.ProductName,
                Price = product.Price,
                IsSeller = (userId == product.SellerId),
                Description = product.Description,
                Seller = product.Seller.UserName ?? string.Empty,
                AddedOn = product.AddedOn.ToString(DateTimeFormat),
                CategoryName = product.Category.Name
            };

            IEnumerable<int> boughtProductIds = await _context
                .ProductsClients
                .AsNoTracking()
                .Where(pc => pc.ClientId == userId && pc.IsDeleted == false)
                .Select(pc => pc.ProductId)
                .ToListAsync();

            model.HasBought = boughtProductIds.Contains(product.Id);

            return View(model);
        }

        [HttpGet]
        public async Task<IActionResult> Add()
        {
            ProductInputViewModel model = new ProductInputViewModel();
            model.Categories = await GetCategories();

            return View(model);
        }

        [HttpPost]
        public async Task<IActionResult> Add(ProductInputViewModel inputModel)
        {
            if (ModelState.IsValid == false)
            {
                inputModel.Categories = await GetCategories();
                return View(inputModel); 
            }

            if (DateTime.TryParseExact(inputModel.AddedOn, DateTimeFormat, CultureInfo.InvariantCulture,
                    DateTimeStyles.None, out DateTime addedOnDateTime) == false)
            {
                inputModel.Categories = await GetCategories();
                ModelState.AddModelError(nameof(inputModel.AddedOn), DateTimeErrorMessage);
                return View(inputModel);
            }

            Product newProduct = new Product()
            {
                ProductName = inputModel.ProductName,
                Description = inputModel.Description,
                Price = inputModel.Price,
                ImageUrl = inputModel.ImageUrl,
                AddedOn = addedOnDateTime,
                SellerId = GetUserId(),
                CategoryId = inputModel.CategoryId,
            };

            await _context.Products.AddAsync(newProduct);
            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int id)
        {
            string userId = GetUserId();

            Product? product = await _context
                .Products
                .AsNoTracking()
                .FirstOrDefaultAsync(p => p.Id == id && p.SellerId == userId && p.IsDeleted == false);

            if (product == null)
            {
                return RedirectToAction(nameof(Index));
            }


            ProductEditInputModel model = new ProductEditInputModel()
            {
                ProductName = product.ProductName,
                Price = product.Price,
                Description = product.Description,
                ImageUrl = product.ImageUrl,
                AddedOn = product.AddedOn.ToString(DateTimeFormat),
                CategoryId = product.CategoryId,
                Categories = await GetCategories(),
                SellerId = product.SellerId
            };

            return View(model);
        }

        [HttpPost]
        public async Task<IActionResult> Edit(ProductEditInputModel inputModel, int id)
        {
            string userId = GetUserId();

            Product? product = await _context
                .Products
                .FirstOrDefaultAsync(p => p.Id == id && p.SellerId == userId && p.IsDeleted == false);

            if (product == null)
            {
                return RedirectToAction(nameof(Index));
            }

            if (ModelState.IsValid == false)
            {
                inputModel.Categories = await GetCategories();
                return View(inputModel);
            }

            if (DateTime.TryParseExact(inputModel.AddedOn, DateTimeFormat, CultureInfo.InvariantCulture,
                    DateTimeStyles.None, out DateTime addedOnDateTime) == false)
            {
                inputModel.Categories = await GetCategories();
                ModelState.AddModelError(nameof(inputModel.AddedOn), DateTimeErrorMessage);
                return View(inputModel);
            }

            product.ProductName = inputModel.ProductName;
            product.Description = inputModel.Description;
            product.Price = inputModel.Price;
            product.ImageUrl = inputModel.ImageUrl;
            product.AddedOn = addedOnDateTime;
            product.SellerId = inputModel.SellerId;
            product.CategoryId = inputModel.CategoryId;

            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Details), new { id = id });
        }

        [HttpGet]
        public async Task<IActionResult> Delete(int id)
        {
            string userId = GetUserId();

            Product? product =
                await _context
                    .Products
                    .Include(p => p.Seller)
                    .FirstOrDefaultAsync(p =>
                    p.Id == id && p.SellerId == userId && p.IsDeleted == false);

            if (product == null)
            {
                return RedirectToAction(nameof(Index));
            }

            ProductDeleteViewModel model = new ProductDeleteViewModel
            {
                Id = product.Id,
                ProductName = product.ProductName,
                Seller = product.Seller.UserName ?? string.Empty,
                SellerId = product.SellerId
            };

            return View(model);
        }

        [HttpPost]
        public async Task<IActionResult> Delete(ProductDeleteViewModel model)
        {
            string userId = GetUserId();

            Product? product =
                await _context
                    .Products
                    .Include(p => p.Seller)
                    .FirstOrDefaultAsync(p =>
                        p.Id == model.Id && p.SellerId == userId && p.IsDeleted == false);

            if (product == null)
            {
                return RedirectToAction(nameof(Details), model.Id);
            }

            product.IsDeleted = true;

            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        public async Task<IActionResult> Cart()
        {
            string userId = GetUserId();

            IEnumerable<UserCartViewModel> productsClients = await _context
                .ProductsClients
                .Where(pc => pc.ClientId == userId && pc.IsDeleted == false)
                .Select(pc => new UserCartViewModel
                {
                    Id = pc.ProductId,
                    ImageUrl = pc.Product.ImageUrl,
                    ProductName = pc.Product.ProductName,
                    Price = pc.Product.Price,
                }).ToListAsync();

            return View(productsClients);
        }

        [HttpPost]
        public async Task<IActionResult> AddToCart(int id)
        {
            string userId = GetUserId();

            bool hasBoughtProduct = await _context.ProductsClients
                .AnyAsync(pc => pc.ProductId == id && pc.ClientId == userId && pc.IsDeleted == false);

            if (hasBoughtProduct)
            {
                return RedirectToAction(nameof(Index));
            }

            Product? product =
                await _context.Products.FirstOrDefaultAsync(p =>
                    p.Id == id && p.IsDeleted == false && p.SellerId != userId);

            if (product == null)
            {
                return RedirectToAction(nameof(Index));
            }

            ProductClient? productClient = await _context.ProductsClients.FirstOrDefaultAsync(pc =>
                pc.ProductId == id && pc.ClientId == userId);

            if (productClient != null)
            {
                if (productClient.IsDeleted == true)
                {
                    productClient.IsDeleted = false;
                    await _context.SaveChangesAsync();
                    return RedirectToAction(nameof(Cart));
                }

                return RedirectToAction(nameof(Index));
            }

            await _context.ProductsClients.AddAsync(new ProductClient()
            {
                ClientId = userId,
                ProductId = product.Id
            });

            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Cart));
        }

        [HttpPost]
        public async Task<IActionResult> RemoveFromCart(int id)
        {
            string userId = GetUserId();


            ProductClient? productClient = await _context.ProductsClients.FirstOrDefaultAsync(pc =>
                pc.ProductId == id && pc.ClientId == userId);

            if (productClient == null)
            {
                return RedirectToAction(nameof(Cart));
            }

            productClient.IsDeleted = true;
            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }

        private async Task<IEnumerable<CategorySelectList>> GetCategories()
        {
            IEnumerable<CategorySelectList> categories = await _context
                .Categories
                .AsNoTracking()
                .Select(c => new CategorySelectList()
                {
                    Id = c.Id,
                    Name = c.Name,
                }).ToListAsync();

            return categories;
        }

        private string GetUserId()
        {
            string userId = User.FindFirst(ClaimTypes.NameIdentifier)?.Value ?? string.Empty;
            return userId;
        }
    }
}
