using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Round
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public List<Game> Games { get; set; } = new List<Game>();

    }
}