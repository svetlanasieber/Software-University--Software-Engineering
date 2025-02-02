using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;

namespace FootballBetting.DomainClasses.CustomAttributes
{
    class CapitalsLetAttribute :ValidationAttribute
    {

        public override bool IsValid(object value)
        {
            var initial = value as string;

            if (initial==null)
            {
                return false;
            }


            return initial.All(i => char.IsLetter(i) && char.IsUpper(i));
        }



    }
}
