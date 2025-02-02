using System;
using BankSystem.Data;
using System.Linq;

namespace BankSystem.Client.Commands
{
    internal class AddInterestCommand
    {
        internal static void AddInterest(BankSystemContext db, string[] argumets)
        {
            var bankAccount = argumets[0]+" "+argumets[1]+" "+argumets[2];

            try
            {
                var account = db.SavingAccounts.FirstOrDefault(x => x.AccountNumber == bankAccount);

                var loggedUser = db.Users.FirstOrDefault(u => u.IsLogged
                                                          && u.SavingAccounts.Any(a => a.AccountNumber == account.AccountNumber));
                if (loggedUser==null)
                {
                    Console.WriteLine("There is not user logged in or logged user don't have such account");
                    return;
                }


                account.AddInterest();
                db.SaveChanges();
                Console.WriteLine("Interest Applyed Successully");

            }
            catch (Exception)
            {

                Console.WriteLine("Can not apply adding interest");
            }
        }
    }
}