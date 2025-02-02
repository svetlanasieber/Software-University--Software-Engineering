using System;
using BankSystem.Data;
using System.Linq;
using BankSystem.Models;

namespace BankSystem.Client.Commands
{
    internal class WithdrawCommand
    {

        internal static void Withdraw(BankSystemContext db, string[] argumets)
        {
            var accountNumber = argumets[0];
            for (int i = 1; i < argumets.Length-1; i++)
            {
                accountNumber = accountNumber + " " + argumets[i];

            }
            var money = decimal.Parse(argumets.Last());

            try
            {
                var account = db.CheckingAccounts.FirstOrDefault(a => a.AccountNumber == accountNumber) ??
                             (Account) db.SavingAccounts.FirstOrDefault(b => b.AccountNumber == accountNumber);
                var loggedUser = db.Users.FirstOrDefault(u => u.IsLogged
                                                        && (u.SavingAccounts.Any(a => a.AccountNumber == account.AccountNumber)
                                                        || (u.CheckingAccounts.Any(a => a.AccountNumber == account.AccountNumber))));
               

                account.WithdrawMoney(money);
                db.SaveChanges();

                Console.WriteLine("The Withdraw opperation successfull");
            }
            catch (Exception)
            {
                Console.WriteLine("The user is not logged in, or the bank account does not belong to that user");

            }
             
        }
    }
}