using DeskMarket.Data.Models;
using DeskMarket.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.CodeAnalysis;

namespace DeskMarket.Services.Contracts
{
    public interface IProductService
    {
        Task<IEnumerable<ProductIndexViewModel>> GetIndexProductsAsync(string? userId);

        Task<Product?> GetProductByIdAsync(int id);

        Task<ProductAddViewModel> GetAddModelAsync();

        Task AddProductAsync(ProductAddViewModel model, string userId);

        Task AddProductToCartAsync(Product product, string userId);

        Task<IEnumerable<ProductCartViewModel>> GetCartProductsAsync(string userId);

        Task<ProductDetailsViewModel> GetProductDetailsAsync(int id, string? userId);

        Task RemoveProductFromCartAsync(int productId, string userId);

        Task<ProductEditViewModel?> GetProductToEditAsync(int id);

        Task<bool> EditProductAsync(ProductEditViewModel model);
        Task<ProductDeleteViewModel?> GetProductToDeleteAsync(int id, string? userId);
        Task<Product> DeleteProductAsync(int id);
    }
}
