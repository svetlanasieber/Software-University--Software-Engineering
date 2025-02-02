using BankSystem.Models.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace BankSystem.Models
{
    public class SavingAccount : Account
    {
        public readonly object DeductFee;

        public SavingAccount()
        {

        }

        public SavingAccount(string accountNumber, decimal balance, decimal interestRate):base(accountNumber,balance)
        {
            this.InterestRate = interestRate;
        }

        
        public decimal InterestRate { get; set; }

        

        public void AddInterest ()
        {
            this.Balance = this.Balance + this.Balance * (decimal)this.InterestRate;
            
        }




    }
}
