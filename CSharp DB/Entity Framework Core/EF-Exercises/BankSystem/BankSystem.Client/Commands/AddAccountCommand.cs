using System;
using BankSystem.Data;
using System.Linq;
using BankSystem.Models;

namespace BankSystem.Client.Commands
{
    internal class AddAccountCommand
    {

        internal static void AddAccount(BankSystemContext db, string[] argumets)
        {
            var accountType = argumets[0];
            var initBalance = decimal.Parse(argumets[1]);
            var accNumber = RandomBankAccountGenerator();

            try
            {
                switch (accountType)
                {
                    case "SavingAccount":
                        var interestRate = decimal.Parse(argumets[2]);
                        AddSavingAccount(db, accNumber, initBalance, interestRate);
                        break;

                    case "CheckingAccount":
                        var deductFee = decimal.Parse(argumets[2]);
                        AddCheckingAccount(db, accNumber, initBalance, deductFee);
                        break;


                    default:

                        Console.WriteLine("Unknown Command");
                        return;
                }
                db.SaveChanges();
                Console.WriteLine($"Succesfully added account with number {accNumber}");

            }
            catch (Exception)
            {
                Console.WriteLine("There is no logged user");

            }




        }

        private static void AddCheckingAccount(BankSystemContext db, string randomAccountNumber, decimal initBalance, decimal deductFee)
        {
            var user = db.Users.FirstOrDefault(l => l.IsLogged == true);
            user.CheckingAccounts.Add(new CheckingAccount(RandomBankAccountGenerator(), initBalance, deductFee));


        }

        private static void AddSavingAccount(BankSystemContext db, string randomAccountNumber, decimal initBalance, decimal interestRate)
        {

            var user = db.Users.FirstOrDefault(l => l.IsLogged == true);
            user.SavingAccounts.Add(new SavingAccount(RandomBankAccountGenerator(), initBalance, interestRate));
        }






        //Using rather different account format than in term of excercise, but more interesting and realisting for BG
        private static string RandomBankAccountGenerator()
        {
            //BG53 IORT 73758402020000
            var random = new Random();
            return "BG53 IORT 7375840" + random.Next(1000000, 9000000);



        }
    }
}