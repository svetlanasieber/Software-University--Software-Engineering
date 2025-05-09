using System;

namespace Oscars
{
    class Program
    {
        static void Main(string[] args)
        {
            string actorName = Console.ReadLine();
            double points = double.Parse(Console.ReadLine());
            int judgesCount = int.Parse(Console.ReadLine());

            for (int i = 1; i <= judgesCount; i++)
            {
                string judgeName = Console.ReadLine();
                double judgePoints = double.Parse(Console.ReadLine());

                double curPoints = judgeName.Length * judgePoints / 2;
                points += curPoints;

                if (points >= 1250.5)
                {
                    Console.WriteLine($"Congratulations, {actorName} got a nominee for leading role with {points:f1}!");
                    return;
                }
            }

            Console.WriteLine($"Sorry, {actorName} you need {(1250.5 - points):f1} more!");
        }
    }
}