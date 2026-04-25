using System;

namespace P01_GoogleSearches
{
    internal class P01_GoogleSearches
    {
        static void Main(string[] args)
        {
            double moneyPerSearch = double.Parse(Console.ReadLine());
            int users = int.Parse(Console.ReadLine());

            double totalMoney = 0;

            for (int i = 1; i <= users; i++)
            {
                int searches = int.Parse(Console.ReadLine());

                if (searches == 1)
                {
                    continue;
                }

                double currentMoneyPerSearch = moneyPerSearch;

                if (i % 3 == 0)
                {
                    currentMoneyPerSearch *= 3;
                }

                double earned = searches * currentMoneyPerSearch;

                if (searches > 5)
                {
                    earned *= 2;
                }

                totalMoney += earned;
            }

            Console.WriteLine($"Total money earned: {totalMoney:F2}");
        }
    }
}
