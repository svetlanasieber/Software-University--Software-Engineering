using System;

namespace TimePlus15Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int mins = int.Parse(Console.ReadLine());

            int totalMins = hour * 60 + mins + 15;
            int finalHour = totalMins / 60;
            int finalMins = totalMins % 60;

            if (finalHour == 24)
            {
                finalHour = 0;
            }

            if (finalMins < 10)
            {
                Console.WriteLine($"{finalHour}:0{finalMins}");
            }
            else
            {
                Console.WriteLine($"{finalHour}:{finalMins}");
            }
        }
    }
}