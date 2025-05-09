using System;

namespace OnTimeForTheExam
{
    class Program
    {
        static void Main(string[] args)
        {
            int examHour = int.Parse(Console.ReadLine());
            int examMin = int.Parse(Console.ReadLine());
            int arrivalHour = int.Parse(Console.ReadLine());
            int arrivalMin = int.Parse(Console.ReadLine());

            int totalExamTime = examHour * 60 + examMin;
            int totalArrivalTime = arrivalHour * 60 + arrivalMin;
            int totalDiff = Math.Abs(totalExamTime - totalArrivalTime);

            int hoursDiff = totalDiff / 60;
            int minsDiff = totalDiff % 60;

            if (totalExamTime == totalArrivalTime)
            {
                Console.WriteLine("On time");
            }
            else if (totalExamTime > totalArrivalTime)
            {
                if (totalDiff <= 30)
                {
                    Console.WriteLine("On time");
                    Console.WriteLine($"{totalDiff} minutes before the start");
                }
                else
                {
                    Console.WriteLine("Early");

                    if (totalDiff < 60)
                    {
                        Console.WriteLine($"{totalDiff} minutes before the start");
                    }
                    else
                    {
                        if (minsDiff < 10)
                        {
                            Console.WriteLine($"{hoursDiff}:0{minsDiff} hours before the start");
                        }
                        else
                        {
                            Console.WriteLine($"{hoursDiff}:{minsDiff} hours before the start");
                        }
                    }
                }
            }
            else
            {
                Console.WriteLine("Late");

                if (totalDiff < 60)
                {
                    Console.WriteLine($"{totalDiff} minutes after the start");
                }
                else
                {
                    if (minsDiff < 10)
                    {
                        Console.WriteLine($"{hoursDiff}:0{minsDiff} hours after the start");
                    }
                    else
                    {
                        Console.WriteLine($"{hoursDiff}:{minsDiff} hours after the start");
                    }
                }
            }
        }
    }
}