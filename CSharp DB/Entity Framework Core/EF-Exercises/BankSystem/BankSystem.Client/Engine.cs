using BankSystem.Client.Commands;
using BankSystem.Data;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BankSystem.Client
{
    public class Engine
    {
      

      

        public static void Start()
        {

            using (var db = new BankSystemContext())
            {
                db.Database.Migrate();
                ExecuteCommand(db);
                //end using bankSystem Context
            }


        }

        private static void ExecuteCommand(BankSystemContext db)
        {
            var info = String.Empty;

            while (!string.IsNullOrEmpty((info = Console.ReadLine())))
            {
                var tokens = info.Trim().Split(null);
                var argumets = tokens.Skip(1).ToArray();
                var command = tokens[0];
                switch (command)
                {
                    case "Register":
                        RegisterUserCommand.Register(db, argumets);
                        break;

                    case "Login":
                        LoginLogoutCommand.Login(db, argumets);
                        break;

                    case "Logout":
                        LoginLogoutCommand.Logout(db, argumets);
                        break;

                    case "Add":
                        AddAccountCommand.AddAccount(db, argumets);
                        break;

                    case "ListAccounts":
                        {
                            ListAccountCommand.ListAccount(db, argumets);
                        }
                        break;

                    case "Deposit":
                        {
                            DepositCommand.Deposit(db, argumets);
                        }
                        break;

                    case "Withdraw":
                        {
                            WithdrawCommand.Withdraw(db, argumets);
                        }
                        break;

                    case "DeductFee":
                        {
                            DeductFeeCommand.DeductFee(db, argumets);
                        }
                        break;

                    case "AddInterest":
                        {
                            AddInterestCommand.AddInterest(db, argumets);
                        }
                        break;

                    default:
                        Console.WriteLine("Wrong Command");
                        break;
                }
            }
        }






    }




}


