using System;
using BankSystem.Data;
using System.Linq;
using BankSystem.Models;

namespace BankSystem.Client.Commands
{
    internal class DepositCommand
    {
        internal static void Deposit(BankSystemContext db, string[] argumets)
        {
            var accountNumber = argumets[0];
            for (int i = 1; i < argumets.Length-1; i++)
            {
                accountNumber  = accountNumber+" "+ argumets[i];
            }

            var userLogged = db.Users.Where(a => a.IsLogged
                                            && (a.CheckingAccounts.Any(b => b.AccountNumber == accountNumber)
                                            || a.SavingAccounts.Any(b => b.AccountNumber == accountNumber))).ToList();
            if (userLogged.Count==0 || userLogged==null)
            {
                Console.WriteLine("No user is logged, or the account does not belong to logged user");
                return;
            }



            var money = decimal.Parse(argumets.Last());


            try
            {
                var account = db.SavingAccounts.FirstOrDefault(a => a.AccountNumber == accountNumber) ??                                          (Account) db.CheckingAccounts.FirstOrDefault(a => a.AccountNumber == accountNumber);

                account.DepositMoney(money);
                db.SaveChanges();

                Console.WriteLine("Deposit Successfull");
            }

            catch (Exception)
            {
                Console.WriteLine("Can not deposit");
            }





        }
    }
}