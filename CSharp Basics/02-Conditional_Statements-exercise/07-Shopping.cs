using System;

namespace Shopping
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int graphicCardsCount = int.Parse(Console.ReadLine());
            int processorsCount = int.Parse(Console.ReadLine());
            int ramCount = int.Parse(Console.ReadLine());

            double totalGraphicCardsPrice = graphicCardsCount * 250;

            double pricePerProcessor = 0.35 * totalGraphicCardsPrice;
            double totalProcessorsPrice = processorsCount * pricePerProcessor;

            double pricePerRam = 0.10 * totalGraphicCardsPrice;
            double totalRamPrice = ramCount * pricePerRam;

            double totalPrice = totalGraphicCardsPrice + totalProcessorsPrice + totalRamPrice;

            if (graphicCardsCount > processorsCount)
            {
                totalPrice *= 0.85;
            }

            if (budget >= totalPrice)
            {
                double moneyLeft = budget - totalPrice;
                Console.WriteLine($"You have {moneyLeft:f2} leva left!");
            }
            else
            {
                double moneyNeeded = totalPrice - budget;
                Console.WriteLine($"Not enough money! You need {moneyNeeded:f2} leva more!");
            }
        }
    }
}