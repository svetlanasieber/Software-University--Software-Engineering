using AutoMapper;
using SocialNetwork.Data.Models;
using SocialNetwork.Data.Models.Enums;
using SocialNetwork.DataProcessor.ExportDTOs;
using SocialNetwork.DataProcessor.ImportDTOs;
using System.Globalization;

namespace SocialNetwork
{
    public class SocialNetworkProfile : Profile
    {
        

        public SocialNetworkProfile()
        {
            
            this.CreateMap<ImportMessageDto, Message>()
                .ForMember(d => d.SentAt, opt => opt.MapFrom(s => DateTime.Parse(s.SentAt, CultureInfo.InvariantCulture)))
                .ForMember(d => d.Status, opt => opt.MapFrom(s => Enum.Parse<MessageStatus>(s.Status)));

            this.CreateMap<ImportPostDto, Post>()
                .ForMember(d => d.CreatedAt, opt => opt.MapFrom(s => DateTime.Parse(s.CreatedAt, CultureInfo.InvariantCulture)));

            
            this.CreateMap<Post, ExportPostDto>()
                .ForMember(d => d.CreatedAt, opt => opt.MapFrom(s => s.CreatedAt.ToString("yyyy-MM-ddTHH:mm:ss", CultureInfo.InvariantCulture)));

            this.CreateMap<Message, ExportMessageDto>()
                .ForMember(d => d.SentAt, opt => opt.MapFrom(s => s.SentAt.ToString("yyyy-MM-ddTHH:mm:ss", CultureInfo.InvariantCulture)))
                .ForMember(d => d.Status, opt => opt.MapFrom(s => (int)s.Status))
                .ForMember(d => d.SenderUsername, opt => opt.MapFrom(s => s.Sender.Username));
        }
    }
}
