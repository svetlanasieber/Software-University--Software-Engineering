using System;
using BankSystem.Data;
using System.Linq;
using Microsoft.EntityFrameworkCore;

namespace BankSystem.Client.Commands
{
    internal class ListAccountCommand
    {
        internal static void ListAccount(BankSystemContext db, string[] argumets)
        {

            var loggedUsers = db.Users
                .Include(a=>a.SavingAccounts)
                .Include(b=>b.CheckingAccounts)
                .Where(u => u.IsLogged == true)
                .ToList();



            if (loggedUsers.Count==0)
            {
                Console.WriteLine("No Logged Users");
                return;
            }
            //if logged user exist
            if (!(loggedUsers.Count == 0 || loggedUsers == null))
            {

                foreach (var user in loggedUsers)
                {


                    if (user.SavingAccounts.Count > 0)
                    {
                        Console.WriteLine("Saving Accounts:");

                        foreach (var account in user.SavingAccounts)
                        {
                            Console.WriteLine($"--{account.AccountNumber} {account.Balance}");
                        }


                    }

                    if (user.CheckingAccounts.Count > 0)
                    {
                        Console.WriteLine("Checking Accounts:");

                        foreach (var account in user.CheckingAccounts)
                        {
                            Console.WriteLine($"--{account.AccountNumber} {account.Balance}");
                        }


                    }

                }



            }

            

        }
    }
}