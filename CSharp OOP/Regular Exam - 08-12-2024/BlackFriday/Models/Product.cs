using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Models
{
    public abstract class Product
    {
        
        public string ProductName { get; private set; }
        public double BasePrice { get; private set; }
        public virtual double BlackFridayPrice => BasePrice; 
        public bool IsSold { get; private set; } = false;

        
        protected Product(string productName, double basePrice)
        {
            if (string.IsNullOrWhiteSpace(productName))
            {
                throw new ArgumentException("Product name is required.");
            }

            if (basePrice <= 0)
            {
                throw new ArgumentException("Price cannot be zero or negative.");
            }

            ProductName = productName;
            BasePrice = basePrice;
        }

        
        public void UpdatePrice(double newPriceValue)
        {
            if (newPriceValue <= 0)
            {
                throw new ArgumentException("Price cannot be zero or negative.");
            }
            BasePrice = newPriceValue;
        }

        public void ToggleStatus()
        {
            IsSold = !IsSold;
        }

        public override string ToString()
        {
            return $"Product: {ProductName}, Price: {BasePrice:F2}, You Save: {(BasePrice - BlackFridayPrice):F2}";
        }
    }
}
