using BankSystem.Models.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace BankSystem.Models
{
     public abstract class Account : IAccount
    {
        public Account()
        {
        }

        protected Account(string accountNumber, decimal balance)
        {
            this.AccountNumber = accountNumber;
            this.Balance = balance;
        }

        public int Id { get; set; }
        public string AccountNumber { get ; set ; }
        public decimal Balance { get; set ; }

        public void DepositMoney(decimal amount)
        {
            Balance += amount;
        }

        public void WithdrawMoney(decimal amount)
        {
            Balance -= amount;
        }

        public int UserId { get ; set ; }
        public User User { get  ; set ; }
    }
}
