using System;
using BankSystem.Data;
using System.Linq;

namespace BankSystem.Client.Commands
{
    internal class DeductFeeCommand
    {
        internal static void DeductFee(BankSystemContext db, string[] argumets)
        {
            var accountNumber = argumets[0]+" "+argumets[1]+" "+argumets[2];


            //if 
            try
            {
                var account = db.CheckingAccounts.FirstOrDefault(a => a.AccountNumber == accountNumber);
                account.DeductFee();
                var owner = db.Users.Where(a => a.CheckingAccounts.Select(b => b.AccountNumber).FirstOrDefault()==account.AccountNumber);
                if (owner.Select(a=>a.IsLogged).FirstOrDefault()!=true)
                {
                    Console.WriteLine("The Owner is not logged in");
                    return;
                }
                if (account.Balance<0)
                {
                    Console.WriteLine("Can not deduct feee. Not enougth money in bank account.Please Add Some Funds");
                }

                account.DeductFee();
                db.SaveChanges();
                Console.WriteLine("DeductionFeeSuccessfull");
            }
            catch (Exception)
            {
                Console.WriteLine("Failed to deduct fee");
                
            }


        }
    }
}