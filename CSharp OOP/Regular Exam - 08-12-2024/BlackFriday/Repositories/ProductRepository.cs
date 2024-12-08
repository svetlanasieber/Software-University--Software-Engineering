using BlackFriday.Models;
using BlackFriday.Models.Contracts;
using BlackFriday.Repositories.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Repositories
{
    public class ProductRepository : IRepository<Product>
    {
        private readonly List<Product> products;

        public ProductRepository()
        {
            products = new List<Product>();
        }

        public IReadOnlyCollection<Product> Models => products.AsReadOnly();

        public void AddNew(Product product)
        {
            if (!Exists(product.ProductName))
            {
                products.Add(product);
            }
        }

        public Product GetByName(string name)
        {
            return products.FirstOrDefault(p => p.ProductName == name);
        }

        public bool Exists(string name)
        {
            return products.Any(p => p.ProductName == name);
        }
    }
}