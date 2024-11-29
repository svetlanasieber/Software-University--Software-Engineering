using System;

namespace TennisRanklist
{
    class Program
    {
        static void Main(string[] args)
        {
            int tournamentsCount = int.Parse(Console.ReadLine());
            int initialPoints = int.Parse(Console.ReadLine());
            int pointsWon = 0;
            int winsCount = 0;

            for (int i = 1; i <= tournamentsCount; i++)
            {
                string status = Console.ReadLine();

                if (status == "W")
                {
                    pointsWon += 2000;
                    winsCount++;
                }
                else if (status == "F")
                {
                    pointsWon += 1200;
                }
                else
                {
                    pointsWon += 720;
                }
            }

            int avgPoints = (int)Math.Floor((double)pointsWon / tournamentsCount);
            double percentWon = ((double)winsCount / tournamentsCount) * 100;

            Console.WriteLine($"Final points: {initialPoints + pointsWon}");
            Console.WriteLine($"Average points: {avgPoints}");
            Console.WriteLine($"{percentWon:f2}%");
        }
    }
}