namespace DeskMarket.Services.Product.Mapping
{
    using AutoMapper;
    using DeskMarket.Services.Product.Models;
    using DeskMarket.Data.Models;

    public class ProductMapper : Profile
    {
        public ProductMapper()
        {
            this.CreateMap<ProductServiceModel, Product>()
                .ReverseMap();

            this.CreateMap<Product, ProductDetailsModel>()
                .ForMember(dest => dest.Seller, opt => opt.MapFrom(src => src.Seller.UserName))
                .ForMember(dest => dest.CategoryName, opt => opt.MapFrom(src => src.Category.Name));

            this.CreateMap<ProductClient, ProductServiceModel>()
                .IncludeMembers(src => src.Product);
        }
    }
}
