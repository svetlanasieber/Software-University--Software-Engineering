using System;

namespace USDToBGN
{
    class Program
    {
        static void Main(string[] args)
        {
            double usd = Double.Parse(Console.ReadLine());
            double bgn = usd * 1.79549;

            Console.WriteLine(bgn);
        }
    }
}