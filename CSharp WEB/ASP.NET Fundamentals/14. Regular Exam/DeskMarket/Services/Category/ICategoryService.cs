namespace DeskMarket.Services.Category
{
    using DeskMarket.Services.Category.Models;

    public interface ICategoryService
    {
        public Task<IEnumerable<CategoryServiceModel>> GetAllAsync();
    }
}
