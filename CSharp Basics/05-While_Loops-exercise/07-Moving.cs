using System;

namespace Moving
{
    class Program
    {
        static void Main(string[] args)
        {
            int width = int.Parse(Console.ReadLine());
            int length = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());

            string input = Console.ReadLine();

            int totalVolume = width * length * height;

            while (input != "Done")
            {
                int boxesVolume = int.Parse(input);
                totalVolume -= boxesVolume;

                if (totalVolume <= 0)
                {
                    Console.WriteLine($"No more free space! You need {Math.Abs(totalVolume)} Cubic meters more.");
                    return;
                }

                input = Console.ReadLine();
            }

            Console.WriteLine($"{totalVolume} Cubic meters left.");
        }
    }
}