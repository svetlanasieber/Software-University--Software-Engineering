using System;

namespace Salary
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double salary = double.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                string curTab = Console.ReadLine();

                if (curTab == "Facebook")
                {
                    salary -= 150;
                }
                else if (curTab == "Instagram")
                {
                    salary -= 100;
                }
                else if (curTab == "Reddit")
                {
                    salary -= 50;
                }

                if (salary <= 0)
                {
                    Console.WriteLine("You have lost your salary.");
                    return;
                }
            }

            Console.WriteLine($"{Math.Round(salary)}");
        }
    }
}