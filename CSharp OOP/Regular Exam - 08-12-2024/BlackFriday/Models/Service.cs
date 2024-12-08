using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Models
{
    public class Service : Product
    {
        public override double BlackFridayPrice => BasePrice * 0.8;

        public Service(string productName, double basePrice)
            : base(productName, basePrice)
        {
        }
    }
}
