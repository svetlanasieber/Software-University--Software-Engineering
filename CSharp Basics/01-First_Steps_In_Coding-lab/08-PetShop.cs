using System;

namespace PetShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int dogsCount = int.Parse(Console.ReadLine());
            int otherAnimalsCount = int.Parse(Console.ReadLine());

            double totalSum = dogsCount * 2.50 + otherAnimalsCount * 4;

            Console.WriteLine($"{totalSum} lv.");
        }
    }
}
