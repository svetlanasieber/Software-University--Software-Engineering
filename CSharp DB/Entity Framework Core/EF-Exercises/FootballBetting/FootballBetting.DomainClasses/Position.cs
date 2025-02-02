using FootballBetting.DomainClasses.CustomAttributes;
using System.Collections.Generic;

namespace FootballBetting.DomainClasses
{
    public class Position
    {
        [TwoCapitalLetters]
        public string Id { get; set; }

        public string PositionDescription { get; set; }

        public List<Player> Players { get; set; }

    }
}