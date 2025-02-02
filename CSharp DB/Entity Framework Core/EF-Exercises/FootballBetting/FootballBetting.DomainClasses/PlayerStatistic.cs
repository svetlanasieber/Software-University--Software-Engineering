

using System.ComponentModel.DataAnnotations;

namespace FootballBetting.DomainClasses
{
    public class PlayerStatistic
    {
        public int PlayerId { get; set; }

        public Player Player { get; set; }

        public int GameId { get; set; }

        public Game Game { get; set; }

        public int ScoredGoals { get; set; }

        public int Assists { get; set; }

        [Required]
        public int MinutesPlayed { get; set; }



    }
}
//•	PlayerStatistics – Game, Player, Scored Goals, Player Assists, Played Minutes During Game, (PK = Game + Player)