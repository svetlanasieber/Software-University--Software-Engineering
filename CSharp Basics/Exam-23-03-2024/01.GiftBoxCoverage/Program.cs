using System;

namespace GiftBoxCoverage
{
    class Program
    {
        static void Main(string[] args)
        {

            double sideSize = double.Parse(Console.ReadLine());


            int Count = int.Parse(Console.ReadLine());


            double totalBoxArea = sideSize * sideSize * 6;

            double coveredArea = 0;


            for (int i = 1; i <= Count; i++)
            {

                double paperLength = double.Parse(Console.ReadLine());
                double sheetWidth = double.Parse(Console.ReadLine());


                double sheetArea = paperLength * sheetWidth;


                if (i % 5 == 0)
                {
                    continue;
                }


                if (i % 3 == 0)
                {
                    sheetArea *= 0.75;
                }


                coveredArea += sheetArea;
            }


            if (coveredArea >= totalBoxArea)
            {
                double totalPercentage = ((coveredArea - totalBoxArea) / coveredArea) * 100;
                Console.WriteLine("You've covered the gift box!");
                Console.WriteLine($"{totalPercentage:F2}% wrap paper left.");
            }
            else
            {
                double uncoveredPercentage = ((totalBoxArea - coveredArea) / totalBoxArea) * 100;
                Console.WriteLine("You are out of paper!");
                Console.WriteLine($"{uncoveredPercentage:F2}% of the box is not covered.");
            }
        }
    }
}
