using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Competition
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public int CompetitionTypeId { get; set; }
        public CompetitionType CompetitionType { get; set; }
        public List<Game> Games { get; set; } = new List<Game>();

    }
}
//•	Competitions – Id, Name, Type (local, national, international)