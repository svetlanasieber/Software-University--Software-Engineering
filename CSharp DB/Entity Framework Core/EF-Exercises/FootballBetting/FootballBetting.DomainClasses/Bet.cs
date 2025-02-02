using System;
using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Bet
    {
        public int Id { get; set; }
        public decimal BetMoney { get; set; }

        public DateTime DateTimeOfBet { get; set; }

        public int UserId { get; set; }
        public User User { get; set; }

        public List<BetGame> Games { get; set; } = new List<BetGame>();
    }
}
//•	Bets – Id, Bet Money, Date and Time of Bet, User