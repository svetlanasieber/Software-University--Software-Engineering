

namespace FootballBetting.DomainClasses
{
    using FootballBetting.DomainClasses.CustomAttributes;
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Town

    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [CapitalsLet]
        public string CountryId { get; set; }

        [Required]
        public Country Country { get; set; }

       

    }
}
