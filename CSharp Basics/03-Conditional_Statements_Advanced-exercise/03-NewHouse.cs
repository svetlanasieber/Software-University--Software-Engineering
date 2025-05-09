using System;

namespace NewHouse
{
    class Program
    {
        static void Main(string[] args)
        {
            string flowerType = Console.ReadLine();
            int flowerCount = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());

            double totalPrice = 0.0;

            switch (flowerType)
            {
                case "Roses":
                    totalPrice = flowerCount * 5;

                    if (flowerCount > 80)
                    {
                        totalPrice *= 0.9;
                    }
                    break;

                case "Dahlias":
                    totalPrice = flowerCount * 3.80;

                    if (flowerCount > 90)
                    {
                        totalPrice *= 0.85;
                    }
                    break;

                case "Tulips":
                    totalPrice = flowerCount * 2.80;

                    if (flowerCount > 80)
                    {
                        totalPrice *= 0.85;
                    }
                    break;

                case "Narcissus":
                    totalPrice = flowerCount * 3;

                    if (flowerCount < 120)
                    {
                        totalPrice *= 1.15;
                    }
                    break;

                case "Gladiolus":
                    totalPrice = flowerCount * 2.50;

                    if (flowerCount < 80)
                    {
                        totalPrice *= 1.2;
                    }
                    break;
            }

            if (budget >= totalPrice)
            {
                double sumLeft = budget - totalPrice;
                Console.WriteLine($"Hey, you have a great garden with {flowerCount} {flowerType} and {sumLeft:f2} leva left.");
            }
            else
            {
                double sumNeeded = totalPrice - budget;
                Console.WriteLine($"Not enough money, you need {sumNeeded:f2} leva more.");
            }
        }
    }

}