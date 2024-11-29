using System;

namespace TradeCommisions
{
    class Program
    {
        static void Main(string[] args)
        {
            string city = Console.ReadLine();
            double sales = double.Parse(Console.ReadLine());

            switch (city)
            {
                case "Sofia":
                    if (sales < 0)
                    {
                        Console.WriteLine("error");

                    }
                    else if (sales <= 500)
                    {
                        Console.WriteLine($"{(0.05 * sales):f2}");
                    }
                    else if (sales <= 1000)
                    {
                        Console.WriteLine($"{(0.07 * sales):f2}");
                    }
                    else if (sales <= 10000)
                    {
                        Console.WriteLine($"{(0.08 * sales):f2}");
                    }
                    else
                    {
                        Console.WriteLine($"{(0.12 * sales):f2}");
                    }
                    break;

                case "Varna":
                    if (sales < 0)
                    {
                        Console.WriteLine("error");
                    }
                    else if (sales <= 500)
                    {
                        Console.WriteLine($"{(0.045 * sales):f2}");
                    }
                    else if (sales <= 1000)
                    {
                        Console.WriteLine($"{(0.075 * sales):f2}");
                    }
                    else if (sales <= 10000)
                    {
                        Console.WriteLine($"{(0.1 * sales):f2}");
                    }
                    else
                    {
                        Console.WriteLine($"{(0.13 * sales):f2}");
                    }
                    break;

                case "Plovdiv":
                    if (sales < 0) {
                        Console.WriteLine("error");
                    }
                    else if (sales <= 500)
                    {
                        Console.WriteLine($"{(0.055 * sales):f2}");
                    }
                    else if (sales <= 1000)
                    {
                        Console.WriteLine($"{(0.08 * sales):f2}");
                    }
                    else if (sales <= 10000)
                    {
                        Console.WriteLine($"{(0.12 * sales):f2}");
                    }
                    else
                    {
                        Console.WriteLine($"{(0.145 * sales):f2}");
                    }
                    break;

                default:
                    Console.WriteLine("error");
                    break;
            }
        }
    }
}