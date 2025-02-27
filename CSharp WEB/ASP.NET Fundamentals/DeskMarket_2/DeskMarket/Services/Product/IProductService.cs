namespace DeskMarket.Services.Product
{
    using DeskMarket.Services.Product.Models;

    public interface IProductService
    {
        Task<IEnumerable<ProductServiceModel>> GetAllAsync();

        Task<IEnumerable<ProductServiceModel>> GetCartAsync(string userId);

        Task<ProductServiceModel?> GetModelByIdAsync(int id);

        Task<ProductDetailsModel?> GetDetailsModelAsync(string? userId, int id);

        Task<bool> ProductAlreadyAddedAsync(string userId, int productId);

        Task AddToCartAsync(string userId, int id);

        Task RemoveFromCartAsync(string userId, int id);

        Task CreateAsync(ProductServiceModel model);

        Task EditAsync(ProductServiceModel model);

        Task DeleteAsync(int id);
    }
}
