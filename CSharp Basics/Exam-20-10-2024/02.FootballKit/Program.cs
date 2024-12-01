using System;

class Program
{
    static void Main()
    {
        
        double tShirtPrice = double.Parse(Console.ReadLine());
        double targetAmount = double.Parse(Console.ReadLine());

        
        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double shoesPrice = (tShirtPrice + shortsPrice) * 2;

       
        double totalPrice = tShirtPrice + shortsPrice + socksPrice + shoesPrice;

       
        totalPrice -= totalPrice * 0.15;

       
        if (totalPrice >= targetAmount)
        {
            Console.WriteLine("Yes, he will earn the world-cup replica ball!");
            Console.WriteLine($"His sum is {totalPrice:F2} lv.");
        }
        else
        {
            double neededMoney = targetAmount - totalPrice;
            Console.WriteLine("No, he will not earn the world-cup replica ball.");
            Console.WriteLine($"He needs {neededMoney:F2} lv. more.");
        }
    }
}



