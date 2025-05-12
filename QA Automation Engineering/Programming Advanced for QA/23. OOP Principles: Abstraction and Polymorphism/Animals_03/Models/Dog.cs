using System;
namespace Animals.Models
{
    public class Dog : Animal
    {
        //наследени полета: name, favouriteFood

        //конструктор
        public Dog(string name, string favouriteFood) : base(name, favouriteFood)
        {
            //нов празен обект
            //name = null
            //favouriteFood = null
        }

        //наследени методи: abstract ExplainSelf
        public override void ExplainSelf()
        {
            Console.WriteLine($"I am {Name} and my favourite food is {FavouriteFood}");
            Console.WriteLine("BORK");
        }
    }
}

