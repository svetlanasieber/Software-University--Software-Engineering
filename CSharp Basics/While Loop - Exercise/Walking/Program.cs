using System;

namespace Walk
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            int totalSteps = 0;

            while (input != "Going home")
            {
                int steps = int.Parse(input);
                totalSteps += steps;

                if (totalSteps >= 10000)
                {
                    Console.WriteLine("Goal reached! Good job!");
                    Console.WriteLine($"{totalSteps - 10000} steps over the goal!");
                    return;
                }

                input = Console.ReadLine();
            }

            int stepsToHome = int.Parse(Console.ReadLine());
            totalSteps += stepsToHome;

            if (totalSteps >= 10000)
            {
                Console.WriteLine("Goal reached! Good job!");
                Console.WriteLine($"{totalSteps - 10000} steps over the goal!");
            }
            else
            {
                Console.WriteLine($"{10000 - totalSteps} more steps to reach goal.");
            }
        }
    }
}
