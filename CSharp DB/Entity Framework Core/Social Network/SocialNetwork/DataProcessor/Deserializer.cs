using Newtonsoft.Json;
using SocialNetwork.Data;
using SocialNetwork.Data.Models;
using SocialNetwork.Data.Models.Enums;
using SocialNetwork.DataProcessor.ImportDTOs;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Text;
using System.Xml.Serialization;

namespace SocialNetwork.DataProcessor
{
    public class Deserializer
    {
        private const string ErrorMessage = "Invalid data format.";
        private const string DuplicatedDataMessage = "Duplicated data.";
        private const string SuccessfullyImportedMessageEntity = "Successfully imported message (Sent at: {0}, Status: {1})";
        private const string SuccessfullyImportedPostEntity = "Successfully imported post (Creator {0}, Created at: {1})";

        public static string ImportMessages(SocialNetworkDbContext dbContext, string xmlString)
        {
            StringBuilder sb = new StringBuilder();

            XmlSerializer serializer = new XmlSerializer(typeof(ImportMessagesRootDto),
                                       new XmlRootAttribute("Messages"));

            using StringReader reader = new StringReader(xmlString);
            ImportMessagesRootDto messagesDto = (ImportMessagesRootDto)serializer.Deserialize(reader)!;

            List<Message> validMessages = new List<Message>();

            foreach (var messageDto in messagesDto.Messages)
            {
                if (!IsValid(messageDto))
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

               
                DateTime sentAtDate;
                bool isDateValid = DateTime.TryParseExact(messageDto.SentAt, "yyyy-MM-ddTHH:mm:ss", 
                    CultureInfo.InvariantCulture, DateTimeStyles.None, out sentAtDate);

                if (!isDateValid)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

               
                bool isStatusValid = Enum.TryParse<MessageStatus>(messageDto.Status, out MessageStatus status);
                if (!isStatusValid)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

               
                var conversationExists = dbContext.Conversations.Any(c => c.Id == messageDto.ConversationId);
                if (!conversationExists)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                
                var senderExists = dbContext.Users.Any(u => u.Id == messageDto.SenderId);
                if (!senderExists)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                
                bool isDuplicate = validMessages.Any(m => 
                    m.Content == messageDto.Content && 
                    m.SentAt == sentAtDate && 
                    m.Status == status && 
                    m.SenderId == messageDto.SenderId && 
                    m.ConversationId == messageDto.ConversationId);

                if (isDuplicate || dbContext.Messages.Any(m => 
                    m.Content == messageDto.Content && 
                    m.SentAt == sentAtDate && 
                    m.Status == status && 
                    m.SenderId == messageDto.SenderId && 
                    m.ConversationId == messageDto.ConversationId))
                {
                    sb.AppendLine(DuplicatedDataMessage);
                    continue;
                }

                
                Message message = new Message
                {
                    Content = messageDto.Content,
                    SentAt = sentAtDate,
                    Status = status,
                    ConversationId = messageDto.ConversationId,
                    SenderId = messageDto.SenderId
                };
                
                validMessages.Add(message);

                sb.AppendLine(string.Format(SuccessfullyImportedMessageEntity, 
                    message.SentAt.ToString("yyyy-MM-ddTHH:mm:ss"), message.Status));
            }

            dbContext.Messages.AddRange(validMessages);
            dbContext.SaveChanges();

            return sb.ToString().TrimEnd();
        }

        public static string ImportPosts(SocialNetworkDbContext dbContext, string jsonString)
        {
            StringBuilder sb = new StringBuilder();

            ImportPostDto[] postsDtos = JsonConvert.DeserializeObject<ImportPostDto[]>(jsonString)!;

            List<Post> validPosts = new List<Post>();

            foreach (var postDto in postsDtos)
            {
                if (!IsValid(postDto))
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

               
                DateTime createdAtDate;
                bool isDateValid = DateTime.TryParseExact(postDto.CreatedAt, "yyyy-MM-ddTHH:mm:ss",
                    CultureInfo.InvariantCulture, DateTimeStyles.None, out createdAtDate);

                if (!isDateValid)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                
                var creator = dbContext.Users.Find(postDto.CreatorId);
                if (creator == null)
                {
                    sb.AppendLine(ErrorMessage);
                    continue;
                }

                
                bool isDuplicate = validPosts.Any(p =>
                    p.Content == postDto.Content &&
                    p.CreatedAt == createdAtDate &&
                    p.CreatorId == postDto.CreatorId);

                if (isDuplicate || dbContext.Posts.Any(p =>
                    p.Content == postDto.Content &&
                    p.CreatedAt == createdAtDate &&
                    p.CreatorId == postDto.CreatorId))
                {
                    sb.AppendLine(DuplicatedDataMessage);
                    continue;
                }

                
                Post post = new Post
                {
                    Content = postDto.Content,
                    CreatedAt = createdAtDate,
                    CreatorId = postDto.CreatorId
                };
                
                validPosts.Add(post);

                sb.AppendLine(string.Format(SuccessfullyImportedPostEntity,
                    creator.Username, post.CreatedAt.ToString("yyyy-MM-ddTHH:mm:ss")));
            }

            dbContext.Posts.AddRange(validPosts);
            dbContext.SaveChanges();

            return sb.ToString().TrimEnd();
        }

        public static bool IsValid(object dto)
        {
            ValidationContext validationContext = new ValidationContext(dto);
            List<ValidationResult> validationResults = new List<ValidationResult>();

            bool isValid = Validator.TryValidateObject(dto, validationContext, validationResults, true);

            return isValid;
        }
    }
}
