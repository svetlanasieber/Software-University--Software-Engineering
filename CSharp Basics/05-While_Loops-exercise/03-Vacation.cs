using System;

namespace Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            double vacationPrice = double.Parse(Console.ReadLine());
            double availableMoney = double.Parse(Console.ReadLine());

            int consecutiveDaysSpent = 0;
            int totalDays = 0;

            while (availableMoney < vacationPrice)
            {
                string action = Console.ReadLine();
                double sum = double.Parse(Console.ReadLine());
                totalDays++;

                if (action == "spend")
                {
                    if (sum > availableMoney)
                    {
                        availableMoney = 0;
                    }
                    else
                    {
                        availableMoney -= sum;
                    }
                    consecutiveDaysSpent++;
                }
                else
                {
                    availableMoney += sum;
                    consecutiveDaysSpent = 0;
                }

                if (consecutiveDaysSpent == 5)
                {
                    Console.WriteLine("You can't save the money.");
                    Console.WriteLine(totalDays);
                    return;
                }
            }
            Console.WriteLine($"You saved the money for {totalDays} days.");
        }
    }
}