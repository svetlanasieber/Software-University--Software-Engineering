using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using SocialNetwork.Data;
using SocialNetwork.Data.Models;
using System.Text;

namespace SocialNetwork.DataProcessor
{
    public class Serializer
    {
        public static string ExportUsersWithFriendShipsCountAndTheirPosts(SocialNetworkDbContext dbContext)
        {
            
            var friendships = dbContext.Friendships.ToList();

           
            var users = dbContext.Users
                .Include(u => u.Posts)
                .OrderBy(u => u.Username)
                .ToList();

            StringBuilder sb = new StringBuilder();
            
           
            sb.AppendLine("<?xml version=\"1.0\" encoding=\"utf-16\"?>");
            sb.AppendLine("<Users>");

            foreach (var user in users)
            {
               
                int friendshipsCount = friendships.Count(f => f.UserOneId == user.Id || f.UserTwoId == user.Id);
                
                sb.AppendLine($"<User Friendships=\"{friendshipsCount}\">");
                sb.AppendLine($"  <Username>{user.Username}</Username>");
                sb.AppendLine("  <Posts>");

                
                var orderedPosts = user.Posts.OrderBy(p => p.Id).ToList();
                
                foreach (var post in orderedPosts)
                {
                    sb.AppendLine("    <Post>");
                    sb.AppendLine($"      <Content>{post.Content}</Content>");
                    sb.AppendLine($"      <CreatedAt>{post.CreatedAt.ToString("yyyy-MM-ddTHH:mm:ss")}</CreatedAt>");
                    sb.AppendLine("    </Post>");
                }

                sb.AppendLine("  </Posts>");
                sb.AppendLine("</User>");
            }

            sb.AppendLine("</Users>");
            return sb.ToString();
        }

        public static string ExportConversationsWithMessagesChronologically(SocialNetworkDbContext dbContext)
        {
            var conversations = dbContext.Conversations
                .Include(c => c.Messages)
                .ThenInclude(m => m.Sender)
                .OrderBy(c => c.StartedAt)
                .Select(c => new
                {
                    Id = c.Id,
                    Title = c.Title,
                    StartedAt = c.StartedAt.ToString("yyyy-MM-ddTHH:mm:ss"),
                    Messages = c.Messages
                        .OrderBy(m => m.SentAt)
                        .Select(m => new
                        {
                            Content = m.Content,
                            SentAt = m.SentAt.ToString("yyyy-MM-ddTHH:mm:ss"),
                            Status = (int)m.Status,
                            SenderUsername = m.Sender.Username
                        })
                        .ToArray()
                })
                .ToArray();

            return JsonConvert.SerializeObject(conversations, Formatting.Indented);
        }
    }
}
