using System;

namespace SumSeconds
{
    class Program
    {
        static void Main(string[] args) {
            int time1 = int.Parse(Console.ReadLine());
            int time2 = int.Parse(Console.ReadLine());
            int time3 = int.Parse(Console.ReadLine());

            int totalTime = time1 + time2 + time3;
            int mins = totalTime / 60;
            int secs = totalTime % 60;

            if (secs < 10)
            {
                Console.WriteLine($"{mins}:0{secs}");
            }
            else
            {
                Console.WriteLine($"{mins}:{secs}");
            }
        }
    }
}