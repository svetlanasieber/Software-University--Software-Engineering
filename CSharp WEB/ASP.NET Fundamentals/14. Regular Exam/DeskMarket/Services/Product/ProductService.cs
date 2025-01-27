namespace DeskMarket.Services.Product
{
    using AutoMapper;
    using AutoMapper.QueryableExtensions;
    using DeskMarket.Data;
    using DeskMarket.Data.Models;
    using DeskMarket.Services.Common;
    using DeskMarket.Services.Product.Models;
    using Microsoft.EntityFrameworkCore;

    public class ProductService : IProductService
    {
        private readonly ApplicationDbContext data;
        private readonly IMapper mapper;

        public ProductService(ApplicationDbContext data, IMapper mapper)
        {
            this.data = data;
            this.mapper = mapper;
        }

        public async Task<IEnumerable<ProductServiceModel>> GetAllAsync()
        {
            return await this.data
                .Products
                .AllAsNoTracking()
                .ProjectTo<ProductServiceModel>(this.mapper.ConfigurationProvider)
                .ToListAsync();
        }

        public async Task<IEnumerable<ProductServiceModel>> GetCartAsync(string userId)
        {
            return await this.data
                .ProductsClients
                .AsNoTracking()
                .Where(pc => pc.ClientId == userId && !pc.Product.IsDeleted)
                .ProjectTo<ProductServiceModel>(this.mapper.ConfigurationProvider)
                .ToListAsync();
        }

        public async Task<ProductDetailsModel?> GetDetailsModelAsync(string? userId, int id)
        {
            var model = await this.data
               .Products
               .AllAsNoTracking()
               .ProjectTo<ProductDetailsModel>(this.mapper.ConfigurationProvider)
               .FirstOrDefaultAsync(p => p.Id == id);

            if (model == null)
            {
                return null;
            }

            if (userId != null)
            {
                model.HasBought = await this.ProductAlreadyAddedAsync(userId, id);
            }

            return model;
        }

        public async Task<ProductServiceModel?> GetModelByIdAsync(int id)
        {
            return await this.data
                .Products
                .AllAsNoTracking()
                .ProjectTo<ProductServiceModel>(this.mapper.ConfigurationProvider)
                .FirstOrDefaultAsync(p => p.Id == id);
        }

        public async Task<bool> ProductAlreadyAddedAsync(string userId, int productId)
        {
            return await this.data
                .ProductsClients
                .AsNoTracking()
                .AnyAsync(pc => pc.ClientId == userId && pc.ProductId == productId);
        }

        public async Task AddToCartAsync(string userId, int id)
        {
            var productIsAlreadyAdded = await this.data
                .ProductsClients
                .AsNoTracking()
                .AnyAsync(pc => pc.ClientId == userId && pc.ProductId == id);

            if (productIsAlreadyAdded)
            {
                throw new InvalidOperationException("Product is already added!");
            }

            var productClient = new ProductClient()
            {
                ClientId = userId,
                ProductId = id
            };

            this.data.Add(productClient);
            await this.data.SaveChangesAsync();
        }

        public async Task RemoveFromCartAsync(string userId, int id)
        {
            var productClient = await this.data
                .ProductsClients
                .AsNoTracking()
                .FirstOrDefaultAsync(pc => pc.ClientId == userId && pc.ProductId == id)
                ?? throw new InvalidOperationException("Product is not found!");

            this.data.Remove(productClient);
            await this.data.SaveChangesAsync();
        }

        public async Task CreateAsync(ProductServiceModel model)
        {
            var product = this.mapper.Map<Product>(model);
            this.data.Add(product);
            await this.data.SaveChangesAsync();
        }

        public async Task EditAsync(ProductServiceModel model)
        {
            var product = await this.data
                .Products
                .All()
                .FirstOrDefaultAsync(p => p.Id == model.Id)
                ?? throw new InvalidOperationException("Product is not found!");

            this.mapper.Map(model, product);
            await this.data.SaveChangesAsync();
        }

        public async Task DeleteAsync(int id)
        {
            var product = await this.data
               .Products
               .All()
               .FirstOrDefaultAsync(p => p.Id == id)
               ?? throw new InvalidOperationException("Product is not found!");

            product.IsDeleted = true;
            await this.data.SaveChangesAsync();
        }
    }
}
