using System.Collections.Generic;
using System.Linq;

using BlackFriday.Models;
using BlackFriday.Repositories.Contracts;

namespace BlackFriday.Repositories
{
    public class UserRepository : IRepository<User>
    {
        private readonly List<User> users;

        public UserRepository()
        {
            users = new List<User>();
        }

        public IReadOnlyCollection<User> Models => users.AsReadOnly();

        public void AddNew(User user)
        {
            if (!Exists(user.UserName))
            {
                users.Add(user);
            }
        }

        public User GetByName(string name)
        {
            return users.FirstOrDefault(u => u.UserName == name);
        }

        public bool Exists(string name)
        {
            return users.Any(u => u.UserName == name);
        }
    }
}
