using System;

namespace RadiansToDegrees
{
    class Program
    {
        static void Main(string[] args)
        {
            double radians = Double.Parse(Console.ReadLine());
            double degrees = radians * 180 / Math.PI;

            Console.WriteLine(degrees);
        }
    }
}