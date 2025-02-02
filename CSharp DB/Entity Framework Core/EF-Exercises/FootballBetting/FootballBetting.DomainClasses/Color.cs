using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Color
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public List<Team> HomeTeams { get; set; } = new List<Team>();
        public List<Team> GuestTeams { get; set; } = new List<Team>();

        //TODO LIST<Team> Away/Home ???
    }
}
