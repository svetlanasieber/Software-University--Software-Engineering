using System;

namespace Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string projectionType = Console.ReadLine();
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());

            int totalTickets = rows * cols;
            double price = 0.0;

            if (projectionType == "Premiere")
            {
                price = totalTickets * 12;
            }
            else if (projectionType == "Normal")
            {
                price = totalTickets * 7.50;
            }
            else
            {
                price = totalTickets * 5.00;
            }

            Console.WriteLine($"{price:f2} leva");
        }
    }
}