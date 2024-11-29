using System;

namespace SkiTrip
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            string spaceType = Console.ReadLine();
            string grade = Console.ReadLine();

            int nights = days - 1;
            double price = 0.0;

            switch (spaceType)
            {
                case "room for one person":
                    price = nights * 18;
                    break;

                case "apartment":
                    price = nights * 25;

                    if (nights < 10)
                    {
                        price *= 0.7;
                    }
                    else if (nights <= 15)
                    {
                        price *= 0.65;
                    }
                    else
                    {
                        price *= 0.5;
                    }
                    break;

                case "president apartment":
                    price = nights * 35;

                    if (nights < 10)
                    {
                        price *= 0.9;
                    }
                    else if (nights <= 15)
                    {
                        price *= 0.85;
                    }
                    else
                    {
                        price *= 0.8;
                    }
                    break;
            }

            if (grade == "positive")
            {
                price *= 1.25;
            }
            else
            {
                price *= 0.9;
            }

            Console.WriteLine($"{price:f2}");
        }
    }
}