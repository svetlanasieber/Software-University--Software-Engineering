namespace DeskMarket.Common.Mapping
{
    using System.Globalization;

    using AutoMapper;
    using DeskMarket.Models.Product;
    using DeskMarket.Services.Product.Models;

    public class ProductMapper : Profile
    {
        public ProductMapper()
        {
            this.CreateMap<ProductFormModel, ProductServiceModel>()
                .ForMember(dest => dest.AddedOn, opt => opt.MapFrom(src =>
                    DateTimeHelper.ParseExactOrDefault(src.AddedOn, "dd-MM-yyyy")
                ))
                .ReverseMap()
                .ForMember(dest => dest.AddedOn, opt => opt.MapFrom(src => src.AddedOn.ToString("dd-MM-yyyy")));

        }

        private static class DateTimeHelper
        {
            public static DateTime ParseExactOrDefault(string dateString, string format)
            {
                var success = DateTime.TryParseExact(
                    dateString,
                    format, 
                    null,
                    DateTimeStyles.None,
                    out var parsedDate);

                return success ? parsedDate : DateTime.MinValue; 
            }
        }
    }
}
