using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Continent
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public List<CountryContinent> Countries { get; set; } = new List<CountryContinent>();
    }
}