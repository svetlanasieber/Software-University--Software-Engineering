using System;

namespace Traveling
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string destination = input;
                double minBudget = double.Parse(Console.ReadLine());
                double moneySaved = 0.0;

                while (moneySaved < minBudget)
                {
                    double curMoney = double.Parse(Console.ReadLine());
                    moneySaved += curMoney;
                }

                Console.WriteLine($"Going to {destination}!");

                input = Console.ReadLine();
            }
        }
    }
}