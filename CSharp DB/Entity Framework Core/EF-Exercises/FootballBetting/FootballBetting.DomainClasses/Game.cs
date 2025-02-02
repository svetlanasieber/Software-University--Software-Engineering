using System;
using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Game
    {
        public int Id { get; set; }

        public int HomeTeamId { get; set; }
        public Team HomeTeam { get; set; }

        public int AwayTeamId { get; set; }
        public Team AwayYeam { get; set; }

        public int HomeTeamGoals  { get; set; }
        public int AwayTeamGoals { get; set; }

        public DateTime GameDateAndTime { get; set; }

        public double HomeWinTeamBetRate { get; set; }
        public double AwayWinTeamBetRate { get; set; }
        public double DrawGameBetRate { get; set; }
        public int RoundId { get; set; }
        public Round Round { get; set; }

        public int CompetitionId { get; set; }
        public Competition Competition { get; set; }

       
        public List<PlayerStatistic> PlayerStatistics { get; set; } = new List<PlayerStatistic>();
        public List<BetGame> Bets { get; set; }= new List<BetGame>();



    }
}
//•	Games – Id, Home Team, Away Team, Home Goals, Away Goals, Date and Time of Game, Home team Win bet rate, Away Team Win Bet Rate, Draw Game Bet Rate, Round, Competition)