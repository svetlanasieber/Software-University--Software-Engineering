using System;

namespace GodzillaVsKong
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int actorsCount = int.Parse(Console.ReadLine());
            double pricePerClothes = double.Parse(Console.ReadLine());

            double totalClothesPrice = actorsCount * pricePerClothes;
            double decorPrice = 0.10 * budget;

            if (actorsCount > 150)
            {
                totalClothesPrice *= 0.90;
            }

            double totalPrice = totalClothesPrice + decorPrice;

            if (budget >= totalPrice)
            {
                double moneyLeft = budget - totalPrice;
                Console.WriteLine("Action!");
                Console.WriteLine($"Wingard starts filming with {moneyLeft:f2} leva left.");
            }
            else
            {
                double moneyNeeded = totalPrice - budget;
                Console.WriteLine("Not enough money!");
                Console.WriteLine($"Wingard needs {moneyNeeded:f2} leva more.");
            }
        }
    }
}