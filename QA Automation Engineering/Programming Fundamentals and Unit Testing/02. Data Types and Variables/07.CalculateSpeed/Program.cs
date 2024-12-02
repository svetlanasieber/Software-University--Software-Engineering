using System;
using System.Globalization;

class Program
{
    static void Main(string[] args)
    {
       
        //CultureInfo.CurrentCulture = CultureInfo.InvariantCulture;

       
        double distance = double.Parse(Console.ReadLine());

       
        double time = double.Parse(Console.ReadLine());

       
        double speed = distance / time;

       
        Console.WriteLine($"{speed:F2}");
    }
}
