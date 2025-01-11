using System;
using System.Collections.Generic;

internal class Program
{
    static void Main(string[] args)
    {
        double balance = 0;

  
        HashSet<double> validCoins = new HashSet<double> { 0.1, 0.2, 0.5, 1, 2 };

       
        Dictionary<string, double> products = new Dictionary<string, double>
        {
            { "Nuts", 2.0 },
            { "Water", 0.7 },
            { "Crisps", 1.5 },
            { "Soda", 0.8 },
            { "Coke", 1.0 }
        };

       
        string command = Console.ReadLine();
        while (command != "Start")
        {
            if (double.TryParse(command, out double coin))
            {
                if (validCoins.Contains(coin))
                {
                    balance += coin;
                }
                else
                {
                    Console.WriteLine($"Cannot accept {coin}");
                }
            }
            command = Console.ReadLine();
        }

      
        command = Console.ReadLine();
        while (command != "End")
        {
            if (products.ContainsKey(command))
            {
                double productPrice = products[command];

                if (balance >= productPrice)
                {
                    balance -= productPrice;
                    Console.WriteLine($"Purchased {command.ToLower()}");
                }
                else
                {
                    Console.WriteLine("Sorry, not enough money");
                }
            }
            else
            {
                Console.WriteLine("Invalid product");
            }

            command = Console.ReadLine();
        }

        Console.WriteLine($"Change: {balance:F2}");
    }
}
