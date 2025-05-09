using System;

namespace FoodDelivery
{
    class Program
    {
        static void Main(string[] args)
        {
            int chickenMenuCount = int.Parse(Console.ReadLine());
            int fishMenuCount = int.Parse(Console.ReadLine());
            int vegMenuCount = int.Parse(Console.ReadLine());

            double totalMenuPrice = chickenMenuCount * 10.35 + fishMenuCount * 12.40 + vegMenuCount * 8.15;
            double dessertPrice = totalMenuPrice * 0.20;

            double totalPrice = totalMenuPrice + dessertPrice + 2.50;
            Console.WriteLine(totalPrice);
        }
    }
}