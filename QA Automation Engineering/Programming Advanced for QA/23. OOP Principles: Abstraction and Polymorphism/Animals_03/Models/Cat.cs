using System;
namespace Animals.Models
{
    
    public class Cat : Animal
    {


        public Cat(string name, string favouriteFood) : base(name, favouriteFood)
        {
        }

        public override void ExplainSelf()
        {
            Console.WriteLine($"I am {Name} and my favourite food is {FavouriteFood}");
            Console.WriteLine("MEEOW");
        }
    }
}

