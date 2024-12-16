using System;
using System.Linq;

class AverageStockPrice
{
    static void Main()
    {
       
        string input = Console.ReadLine();
        int[] averageStockPrices = input.Split(' ').Select(int.Parse).ToArray();

        
        int N = int.Parse(Console.ReadLine());

        int M = int.Parse(Console.ReadLine());

        
        if (N < 0 || M >= averageStockPrices.Length || N > M)
        {
            Console.WriteLine("Invalid input");
            return;
        }

      
        int sum = 0;
        for (int i = N; i <= M; i++)
        {
            sum += averageStockPrices[i];
        }

    
        double averageResult = (double)sum / (M - N + 1);

       
        Console.WriteLine(averageResult.ToString("F2"));
    }
}
