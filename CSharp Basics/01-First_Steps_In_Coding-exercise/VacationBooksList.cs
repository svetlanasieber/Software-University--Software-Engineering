using System;

namespace VacationBooksList
{
    class Program
    {
        static void Main(string[] args)
        {
            int bookPages = int.Parse(Console.ReadLine());
            int pagesPerHour = int.Parse(Console.ReadLine());
            int days = int.Parse(Console.ReadLine());

            double hoursTotal = Math.Floor((double)bookPages / pagesPerHour);
            double hoursPerDay = Math.Floor((double)hoursTotal / days);

            Console.WriteLine(hoursPerDay);
        }
    }
}