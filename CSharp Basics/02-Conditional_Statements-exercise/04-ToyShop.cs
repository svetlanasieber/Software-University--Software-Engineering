using System;

namespace ToyShop
{
    class Program
    {
        static void Main(string[] args)
        {
            double vacationPrice = double.Parse(Console.ReadLine());
            int puzzleCount = int.Parse(Console.ReadLine());
            int dollsCount = int.Parse(Console.ReadLine());
            int bearsCount = int.Parse(Console.ReadLine());
            int minionsCount = int.Parse(Console.ReadLine());
            int trucksCount = int.Parse(Console.ReadLine());

            double totalPrice = puzzleCount * 2.60 + dollsCount * 3 + bearsCount * 4.10 + minionsCount * 8.20 + trucksCount * 2;
            int totalCount = puzzleCount + dollsCount + bearsCount + minionsCount + trucksCount;

            if (totalCount >= 50)
            {
                totalPrice *= 0.75;
            }

            totalPrice *= 0.9;

            if (totalPrice >= vacationPrice)
            {
                double moneyLeft = totalPrice - vacationPrice;
                Console.WriteLine($"Yes! {moneyLeft:f2}");
            }
            else
            {
                double moneyNeeded = vacationPrice - totalPrice;
                Console.WriteLine($"Not enough money! {moneyNeeded:f2} lv needed.");
            }
        }
    }
}