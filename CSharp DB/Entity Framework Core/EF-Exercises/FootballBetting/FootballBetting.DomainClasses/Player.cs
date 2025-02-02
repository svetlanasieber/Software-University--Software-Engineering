using FootballBetting.DomainClasses.CustomAttributes;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace FootballBetting.DomainClasses
{
    public class Player
    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public int SquadNumber { get; set; }

        [Required]
        public int TeamId { get; set; }
        public Team  Team { get; set; }

        [Required]
        [TwoCapitalLetters]
        public string PosititonId { get; set; }
        [Required]
        public Position Position { get; set; }

        public bool IsInjured { get; set; }

      
        public List<PlayerStatistic> GameStatistics { get; set; } = new List<PlayerStatistic>();
    }
}

//•	Players – Id, Name, Squad Number, Team, Position, Is Currently Injured

