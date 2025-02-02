using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;

namespace FootballBetting.DomainClasses.CustomAttributes
{
    public class TwoCapitalLettersAttribute : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            var positionCode = value as string;

            return (positionCode.All(a => char.IsUpper(a) && char.IsLetter(a))
                    && positionCode.Count()==2);

            
        }

        


    }
}
