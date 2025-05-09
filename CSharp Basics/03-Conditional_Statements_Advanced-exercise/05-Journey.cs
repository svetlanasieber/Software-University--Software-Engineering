using System;

namespace Journey
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            double price = 0.0;
            string destination = "";
            string type = "";

            if (budget <= 100)
            {
                destination = "Bulgaria";

                if (season == "summer")
                {
                    type = "Camp";
                    price = 0.30 * budget;
                }
                else
                {
                    type = "Hotel";
                    price = 0.70 * budget;
                }
            }
            else if (budget <= 1000)
            {
                destination = "Balkans";

                if (season == "summer")
                {
                    type = "Camp";
                    price = 0.40 * budget;
                }
                else
                {
                    type = "Hotel";
                    price = 0.80 * budget;
                }
            }
            else
            {
                destination = "Europe";
                type = "Hotel";
                price = 0.90 * budget;
            }

            Console.WriteLine($"Somewhere in {destination}");
            Console.WriteLine($"{type} - {price:f2}");
        }
    }
}