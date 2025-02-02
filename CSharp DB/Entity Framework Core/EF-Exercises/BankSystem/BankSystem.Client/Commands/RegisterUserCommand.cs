using System;
using BankSystem.Data;
using BankSystem.Models;
using System.Text.RegularExpressions;
using System.Linq;

namespace BankSystem.Client.Commands
{
    internal class RegisterUserCommand
    {
        internal static void Register(BankSystemContext db, string[] argumets)
        {
            var username = argumets[0];
            var password = argumets[1];
            var email = argumets[2];

            if (ValidateData(username, password, email))
            {
                db.Users.Add(new User(username, password, email, false));
                db.SaveChanges();

                Console.WriteLine($"Successfully registered user: {username}");

            }

        }

        private static bool ValidateData(string username, string password, string email)
        {
            var validUsername = ValidateUsername(username);
            var validPassword = ValidatePassword(password);
            var validEmail = ValidateEmail(email);

            if (validUsername  && validPassword && validEmail)
            {
                return true;
            }

            if (!validUsername)
            {
                Console.WriteLine("Invalid User name");
               
            }

            if (!validPassword)
            {
                Console.WriteLine("Invalid Password");
               
            }

            if (!validEmail)
            {
                Console.WriteLine("Invalid Email");

            }

                return false;

        }

        private static bool ValidateEmail(string email)
        {
            var emailPattern = @"(?<=\s|^)([a-zA-Z0-9]+(?:[_.-][a-zA-Z0-9]+)*@[a-z]+\-?[a-z]+(?:\.[a-z]+)+)\b";
            var regex = new Regex(emailPattern);
            var isMatch = regex.IsMatch(email);

            return isMatch;
        }

        private static bool ValidatePassword(string password)
        {
            if ((password.Length > 6) && password.Any(a => char.IsDigit(a)) && password.Any(a => char.IsLower(a)) && password.Any(a => char.IsUpper(a)))
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        private static bool ValidateUsername(string username)
        {
            var usernamePattern = @"^[a-zA-Z][a-zA-Z0-9_]{2,}$";
            var regex = new Regex(usernamePattern);
            var isMatch = regex.IsMatch(username);

            return isMatch;
        }


    }
}