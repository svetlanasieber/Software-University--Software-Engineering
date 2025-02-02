using FootballBetting.DomainClasses.CustomAttributes;
using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Country
    {
        [CapitalsLet]
        public string Id { get; set; }

        public string Name { get; set; }

       
        public List<Town> Towns { get; set; } = new List<Town>();

        public List<CountryContinent> Continents { get; set; } = new List<CountryContinent>();
    }
}