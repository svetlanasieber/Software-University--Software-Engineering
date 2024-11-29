using System;

namespace LunchBreak
{
    class Program
    {
        static void Main(string[] args)
        {
            string movie = Console.ReadLine();
            int episodeDuration = int.Parse(Console.ReadLine());
            int breakDuration = int.Parse(Console.ReadLine());

            double lunchTime = (1.0 / 8) * breakDuration;
            double leisureTime = (1.0 / 4) * breakDuration;

            double timeLeft = breakDuration - (lunchTime + leisureTime);

            if (timeLeft >= episodeDuration)
            {
                Console.WriteLine($"You have enough time to watch {movie} and left with {Math.Ceiling(timeLeft - episodeDuration)} minutes free time.");
            }
            else
            {
                Console.WriteLine($"You don't have enough time to watch {movie}, you need {Math.Ceiling(episodeDuration - timeLeft)} more minutes.");
            }
        }
    }
}