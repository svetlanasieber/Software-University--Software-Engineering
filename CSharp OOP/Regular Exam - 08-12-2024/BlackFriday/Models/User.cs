using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackFriday.Models
{
    public abstract class User
    {
        
        public string UserName { get; private set; }
        public virtual bool HasDataAccess { get; }
        public virtual string Email { get; private set; }

       
        protected User(string userName, string email, bool hasDataAccess)
        {
            if (string.IsNullOrWhiteSpace(userName))
            {
                throw new ArgumentException("Username is required.");
            }

            if (!hasDataAccess && string.IsNullOrWhiteSpace(email))
            {
                throw new ArgumentException("Email is required.");
            }

            UserName = userName;
            Email = hasDataAccess ? "hidden" : email;
        }

       
        public override string ToString()
        {
            string status = HasDataAccess ? "Admin" : "Client";
            return $"{UserName} - Status: {status}, Contact Info: {Email}";
        }
    }
}
