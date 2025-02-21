using DeskMarket.Data;
using DeskMarket.Data.Models;
using DeskMarket.Models;
using DeskMarket.Services.Contracts;
using Microsoft.AspNetCore.Mvc;
using Microsoft.CodeAnalysis;
using Microsoft.EntityFrameworkCore;
using System.Globalization;

namespace DeskMarket.Services
{
    public class ProductService : IProductService
    {
        private readonly ApplicationDbContext context;

        public ProductService(ApplicationDbContext context)
        {
            this.context = context;
        }

        public async Task<IEnumerable<ProductIndexViewModel>> GetIndexProductsAsync(string? userId)
        {
            return await context.Products
                .Select(p => new ProductIndexViewModel
                {
                    Id = p.Id,
                    ProductName = p.ProductName,
                    Price = p.Price,
                    ImageUrl = p.ImageUrl,
                    IsSeller = userId != null && p.SellerId == userId,
                    HasBought = userId != null && context.ProductsClients.Any(pc => pc.ProductId == p.Id && pc.ClientId == userId)
                })
                .ToListAsync();
        }

        public async Task AddProductAsync(ProductAddViewModel model, string userId)
        {
            string dateTimeString = $"{model.AddedOn}";

            if (!DateTime.TryParseExact(dateTimeString,
                                      "dd-MM-yyyy",
                                      CultureInfo.InvariantCulture,
                                      DateTimeStyles.None,
                                      out DateTime addedOn))
            {
                throw new InvalidOperationException("Invalid date format.");
            }

            var product = new Product
            {
                ProductName = model.ProductName,
                Description = model.Description,
                Price = model.Price,
                ImageUrl = model.ImageUrl,
                SellerId = userId,
                AddedOn = addedOn,
                CategoryId = model.CategoryId

            };

            await context.Products.AddAsync(product);
            await context.SaveChangesAsync();
        }

        public async Task<ProductAddViewModel> GetAddModelAsync()
        {
            var categories = await context.Categories
                .Select(c => new CategoryViewModel
                {
                    Id = c.Id,
                    Name = c.Name
                })
                .ToListAsync();

            var model = new ProductAddViewModel
            {
                Categories = categories
            };

            return model;
        }

        public async Task<Product?> GetProductByIdAsync(int id)
        {
            return context.Products.FirstOrDefault(p => p.Id == id);
        }


        public async Task AddProductToCartAsync(Product product, string userId)
        {
            var productClient = new ProductClient
            {
                ProductId = product.Id,
                ClientId = userId
            };

            await context.ProductsClients.AddAsync(productClient);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<ProductCartViewModel>> GetCartProductsAsync(string userId)
        {
            return await context.ProductsClients
                .Where(pc => pc.ClientId == userId)
                .Select(pc => new ProductCartViewModel
                {
                    Id = pc.Product.Id,
                    ProductName = pc.Product.ProductName,
                    ImageUrl = pc.Product.ImageUrl,
                    Price = pc.Product.Price
                })
                .ToListAsync();
        }

        public async Task<ProductDetailsViewModel> GetProductDetailsAsync(int id, string? userId)
        {
            var product = await context.Products
                .Include(p => p.Category)
                .Include(p => p.Seller)
                .FirstOrDefaultAsync(p => p.Id == id);

            if (product == null)
            {
                return null;
            }

            return new ProductDetailsViewModel
            {
                Id = product.Id,
                ProductName = product.ProductName,
                Description = product.Description,
                Price = product.Price,
                ImageUrl = product.ImageUrl,
                CategoryName = product.Category.Name,
                SellerId = product.SellerId,
                Seller = product.Seller.UserName,
                AddedOn = product.AddedOn.ToString("dd-MM-yyyy"),
                IsSeller = userId != null && product.SellerId == userId,
                HasBought = userId != null && context.ProductsClients.Any(pc => pc.ProductId == product.Id && pc.ClientId == userId)
            };
        }

        public async Task RemoveProductFromCartAsync(int productId, string userId)
        {
            var productClient = await context.ProductsClients
                .FirstOrDefaultAsync(pc => pc.ProductId == productId && pc.ClientId == userId);

            if(productClient == null)
            {
                return;
            }

            context.ProductsClients.Remove(productClient);
            await context.SaveChangesAsync();
        }

        public async Task<ProductEditViewModel?> GetProductToEditAsync(int id)
        {
            var categories = await context.Categories
                .Select(c => new CategoryViewModel
                {
                    Id = c.Id,
                    Name = c.Name
                })
                .ToListAsync();

            var productToEdit = await context.Products
                .Where(p => p.Id == id)
                .Select(p => new ProductEditViewModel
                {
                    Id = p.Id,
                    ProductName = p.ProductName,
                    Description = p.Description,
                    Price = p.Price,
                    ImageUrl = p.ImageUrl,
                    AddedOn = p.AddedOn.ToString("dd-MM-yyyy"),
                    CategoryId = p.CategoryId,
                    SellerId = p.SellerId,
                    Categories = categories
                })
                .FirstOrDefaultAsync();

            return productToEdit;
        }

        public async Task<bool> EditProductAsync(ProductEditViewModel model)
        {
            string dateTimeString = $"{model.AddedOn}";

            if (!DateTime.TryParseExact(dateTimeString,
                                      "dd-MM-yyyy",
                                      CultureInfo.InvariantCulture,
                                      DateTimeStyles.None,
                                      out DateTime addedOn))
            {
                throw new InvalidOperationException("Invalid date format.");
            }

            Product? product = await context.Products.FirstOrDefaultAsync(p => p.Id == model.Id);

            if(product == null)
            {
                return false;
            }

            product.ProductName = model.ProductName;
            product.Description = model.Description;
            product.Price = model.Price;
            product.ImageUrl = model.ImageUrl;
            product.CategoryId = model.CategoryId;
            product.AddedOn = addedOn;

            await context.SaveChangesAsync();
            return true;
        }

        public async Task<ProductDeleteViewModel?> GetProductToDeleteAsync(int id, string? userId)
        {
            var productToDelete =  await context.Products
                .Where(p => p.Id == id && p.SellerId == userId)
                .Select(p => new ProductDeleteViewModel
                {
                    Id = p.Id,
                    ProductName = p.ProductName,
                    SellerId = p.SellerId,
                    Seller = p.Seller.UserName
                })
                .FirstOrDefaultAsync();

            return productToDelete;
        }

        public async Task<Product> DeleteProductAsync(int id)
        {
            var productToDelete = await context.Products.FirstOrDefaultAsync(p => p.Id == id);

            productToDelete.IsDeleted = true;
            await context.SaveChangesAsync();
            return productToDelete;
        }
    }
}
