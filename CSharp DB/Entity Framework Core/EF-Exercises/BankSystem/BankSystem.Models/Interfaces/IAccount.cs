using System;
using System.Collections.Generic;
using System.Text;

namespace BankSystem.Models.Interfaces
{
    public interface IAccount
    {

         string AccountNumber { get; set; }
         decimal Balance { get; set; }

         void DepositMoney(decimal amount);
         void WithdrawMoney(decimal amount);

         int UserId { get; set; }
        User User { get; set; }

    }
}
