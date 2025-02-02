namespace FootballBetting.DomainClasses
{
    using FootballBetting.DomainClasses.CustomAttributes;
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;


    public class Team
    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        public byte[] Logo { get; set; }

        [Required]
        [MinLength(1)]
        [MaxLength(3)]
        [CapitalsLet]
        public string Initials { get; set; }

        
        public int PrimaryColorId { get; set; }
        [Required]
        public Color PrimaryColor { get; set; }

        public int SecondaryColorId { get; set; }
        [Required]
        public Color SecondaryColor { get; set; }

        public int HomeTownId { get; set; }
        [Required]
        public Town HomeTown { get; set; }

       

        [Required]
        public decimal Budget { get; set; }

        public List<Player> Players { get; set; } = new List<Player>();
        public List<Game> AwayGames { get; set; } = new List<Game>();
        public List<Game> HomeGames { get; set; } = new List<Game>();

    }
}
//•	Teams – Id, Name, Logo, 3 letter Initials(JUV, LIV, ARS…), Primary Kit Color, Secondary Kit Color, Town, Budget