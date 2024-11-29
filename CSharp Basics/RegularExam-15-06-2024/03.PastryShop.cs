using System;

class Program
{
    static void Main()
    {
        string cakeType = Console.ReadLine();
        int cakeCount = int.Parse(Console.ReadLine());
        int purchaseDay = int.Parse(Console.ReadLine());

        double finalPrice = 0;

        if (purchaseDay <= 15)
        {
            if (cakeType == "Cake")
            {
                finalPrice = cakeCount * 24;
            }
            else if (cakeType == "Souffle")
            {
                finalPrice = cakeCount * 6.66;
            }
            else
            {
                finalPrice = cakeCount * 12.60;
            }
        }
        else
        {
            if (cakeType == "Cake")
            {
                finalPrice = cakeCount * 28.70;
            }
            else if (cakeType == "Souffle")
            {
                finalPrice = cakeCount * 9.80;
            }
            else
            {
                finalPrice = cakeCount * 16.98;
            }
        }

        if (purchaseDay <= 22)
        {
            if (finalPrice >= 100 && finalPrice <= 200)
            {
                finalPrice *= 0.85;
            }
            else if (finalPrice > 200)
            {
                finalPrice *= 0.75;
            }
        }

        if (purchaseDay <= 15)
        {
            finalPrice *= 0.9;
        }

        Console.WriteLine($"{finalPrice:F2}");
    }
}

