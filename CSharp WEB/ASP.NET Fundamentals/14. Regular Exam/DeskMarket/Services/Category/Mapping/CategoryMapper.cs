namespace DeskMarket.Services.Category.Mapping
{
    using AutoMapper;
    using DeskMarket.Data.Models;
    using DeskMarket.Services.Category.Models;

    public class CategoryMapper : Profile
    {
        public CategoryMapper()
        {
            this.CreateMap<Category, CategoryServiceModel>();
        }
    }
}
