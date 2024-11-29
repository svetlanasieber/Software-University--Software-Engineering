using System;

namespace CleverLily
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double washerPrice = double.Parse(Console.ReadLine());
            int toyPrice = int.Parse(Console.ReadLine());

            int totalMoney = 0;
            int moneyWon = 10;

            for (int curBirthday = 1; curBirthday <= n; curBirthday++)
            {
                if (curBirthday % 2 == 0)
                {
                    totalMoney += moneyWon - 1;
                    moneyWon += 10;
                }
                else
                {
                    totalMoney += toyPrice;
                }
            }

            if (totalMoney >= washerPrice)
            {
                double moneyLeft = totalMoney - washerPrice;
                Console.WriteLine($"Yes! {moneyLeft:f2}");
            }
            else
            {
                double moneyNeeded = washerPrice - totalMoney;
                Console.WriteLine($"No! {moneyNeeded:f2}");
            }
        }
    }
}