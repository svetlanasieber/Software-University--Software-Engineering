using System;

class ChristmasGifts
{
    static void Main(string[] args)
    {
        int toyPrice = 5;
        int sweaterPrice = 15;
        int kidCount = 0;
        int adultCount = 0;
        int toysMoney = 0;
        int sweaterMoney = 0;

        while (true)
        {
            string command = Console.ReadLine();
            if (command == "Christmas")
            {
                break;
            }

            int years = int.Parse(command);

            if (years <= 16)
            {
                kidCount++;
                toysMoney = toyPrice * kidCount;
            }
            else
            {
                adultCount++;
                sweaterMoney = sweaterPrice * adultCount;
            }
        }

        Console.WriteLine($"Number of adults: {adultCount}");
        Console.WriteLine($"Number of kids: {kidCount}");
        Console.WriteLine($"Money for toys: {toysMoney}");
        Console.WriteLine($"Money for sweaters: {sweaterMoney}");
    }
}

