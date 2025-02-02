

using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace BankSystem.Models
{
    public class User
    {
        public User()
        {


        }
        public User(string username, string password, string email, bool isLogged)
        {
            this.Name = username;
            this.Password = password;
            this.Email = email;
            this.IsLogged = isLogged;
            this.SavingAccounts = new List<SavingAccount>();
            this.CheckingAccounts = new List<CheckingAccount>();

        }



        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public string Password { get; set; }

        [Required]
        public string Email { get; set; }
        //•	User – username(required), password(required), email address(required)

        public bool IsLogged;

        public List<SavingAccount> SavingAccounts { get; set; } = new List<SavingAccount>();
        public List<CheckingAccount> CheckingAccounts { get; set; } = new List<CheckingAccount>();


    }
}
