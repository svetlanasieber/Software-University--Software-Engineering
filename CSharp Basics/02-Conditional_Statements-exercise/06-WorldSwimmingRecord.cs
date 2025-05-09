using System;

namespace WorldSwimmingRecord
{
    class Program
    {
        static void Main(string[] args)
        {
            double record = double.Parse(Console.ReadLine());
            double distance = double.Parse(Console.ReadLine());
            double secondsPerMeter = double.Parse(Console.ReadLine());

            double seconds = distance * secondsPerMeter;
            double delayCount = Math.Floor(distance / 15);
            double delaySeconds = delayCount * 12.5;


            double totalSeconds = seconds + delaySeconds;


            if (totalSeconds < record)
            {
                Console.WriteLine($"Yes, he succeeded! The new world record is {totalSeconds:f2} seconds.");
            }
            else
            {
                double secondsSlower = totalSeconds - record;
                Console.WriteLine($"No, he failed! He was {secondsSlower:f2} seconds slower.");
            }
        }
    }
}