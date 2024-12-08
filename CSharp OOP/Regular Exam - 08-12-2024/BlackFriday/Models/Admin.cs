using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Models
{
    public class Admin : User
    {
        
        public override bool HasDataAccess => true;

        
        public Admin(string userName, string email)
            : base(userName, email, true)
        {
        }
    }
}
