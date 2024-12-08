using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Models
{
    public class Item : Product
    {
        public override double BlackFridayPrice => BasePrice * 0.7;

        public Item(string productName, double basePrice)
            : base(productName, basePrice)
        {
        }
    }
}
