using System;

internal class Program
{
    static void Main(string[] args)
    {
        string product = Console.ReadLine(); // "Banana", "Apple", "Kiwi"
        string dayType = Console.ReadLine(); // "Weekday", "Weekend"

        double price = 0;

        if (product == "Banana")
        {
            if (dayType == "Weekday")
            {
                price = 2.50;
            }
            else
            {
                price = 2.70;
            }
        }
        else if (product == "Apple")
        {
            if (dayType == "Weekday")
            {
                price = 1.30;
            }
            else
            {
                price = 1.60;
            }
        }
        else if (product == "Kiwi")
        {
            if (dayType == "Weekday")
            {
                price = 2.20;
            }
            else
            {
                price = 3.00;
            }
        }

       
        Console.WriteLine($"{price:F2}");
    }
}
