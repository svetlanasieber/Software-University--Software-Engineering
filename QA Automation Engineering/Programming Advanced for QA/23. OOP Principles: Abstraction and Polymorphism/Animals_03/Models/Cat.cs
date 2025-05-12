using System;
namespace Animals.Models
{
    //клас Cat наследява клас Animal
    public class Cat : Animal
    {

        //наследени полета: name, favouriteFood

        //конструктор
        public Cat(string name, string favouriteFood) : base(name, favouriteFood)
        {
            //нов празен обект
            //name = null
            //favouriteFood = null
        }

        //наследени методи: abstract ExplainSelf
        public override void ExplainSelf()
        {
            Console.WriteLine($"I am {Name} and my favourite food is {FavouriteFood}");
            Console.WriteLine("MEEOW");
        }
    }
}

