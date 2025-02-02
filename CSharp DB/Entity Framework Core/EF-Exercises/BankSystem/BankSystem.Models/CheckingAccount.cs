using BankSystem.Models.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace BankSystem.Models
{
    public class CheckingAccount : Account
    {
        public CheckingAccount()
        {

        }

        public CheckingAccount(string accountNumber,decimal balance,decimal fee ):base(accountNumber,balance)
        {
            this.Fee = fee;
        }

        public void DeductFee()
        {
            this.Balance -= this.Fee;
        }


        public decimal Fee { get; set; }

        

    }
}
