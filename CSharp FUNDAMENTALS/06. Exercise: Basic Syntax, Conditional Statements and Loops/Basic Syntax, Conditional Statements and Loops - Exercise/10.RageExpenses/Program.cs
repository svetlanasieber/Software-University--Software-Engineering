using System;
using System.Collections.Generic;



internal class Program
{
    static void Main(string[] args)
    {
        int gamesCount = int.Parse(Console.ReadLine());
        double headsetPrice = double.Parse(Console.ReadLine());
        double mousePrice = double.Parse(Console.ReadLine());
        double keyboardPrice = double.Parse(Console.ReadLine());
        double displayPrice = double.Parse(Console.ReadLine());
        double expenses = 0;


        int headsetsTrashed = 0;
 
        int miceTrashed = 0;
       
        int keyboardsTrashed = 0;
      
        int displaysTrashed = 0;

        for (int i = 1; i <= gamesCount; i++)
        {
            if (i % 2 == 0)
            {
                headsetsTrashed++;
            }
            
            if (i % 3 == 0)
            {
                miceTrashed++;
            }
            
            if (i % 2 == 0 && i % 3 == 0)
            {
                keyboardsTrashed++;
                if (keyboardsTrashed % 2 == 0)
                {
                    displaysTrashed++;
                }
            }
        }

        expenses = headsetsTrashed * headsetPrice +
                   miceTrashed * mousePrice +
                   keyboardsTrashed * keyboardPrice+
                   displaysTrashed * displayPrice;

        Console.WriteLine($"Rage expenses: {expenses:F2} lv.");
    }
}

