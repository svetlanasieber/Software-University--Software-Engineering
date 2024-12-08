using BlackFriday.Models.Contracts;
using BlackFriday.Repositories;
using BlackFriday.Repositories.Contracts;

namespace BlackFriday.Models
{
    public class Application
    {
       
        public IRepository<Product> Products { get; private set; }
        public IRepository<User> Users { get; private set; }

        
        public Application()
        {
            Products = new ProductRepository();
            Users = new UserRepository();
        }
    }
}
