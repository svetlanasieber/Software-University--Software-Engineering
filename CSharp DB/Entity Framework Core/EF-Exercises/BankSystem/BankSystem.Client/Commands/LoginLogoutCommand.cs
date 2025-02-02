using System;
using BankSystem.Data;
using System.Linq;

namespace BankSystem.Client.Commands
{
    internal class LoginLogoutCommand
    {
        internal static void Logout(BankSystemContext db, string[] argumets)
        {

            var user=db.Users.FirstOrDefault(u => u.IsLogged == true);
            if (user!=null)
            {
                user.IsLogged = false;
                db.SaveChanges();
                Console.WriteLine("Successfully logged in");
            }
            else
            {
                Console.WriteLine("There is no logged in user");
            }
        }

        internal static void Login(BankSystemContext db, string[] argumets)
        {
            var username = argumets[0];
            var password = argumets[1];


            var user = db.Users.Where(u => u.Name == username && u.Password == password).FirstOrDefault();
            if (user==null)
            {
                Console.WriteLine("Wrong Username or Password");
                return;
            }

            else
            {
                user.IsLogged = true;
                db.SaveChanges();

                Console.WriteLine($"Successfully logged {username}");
            }
 
            

        }
    }
}