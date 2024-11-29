using System;

namespace SumOfTwoNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());
            int magicNum = int.Parse(Console.ReadLine());

            int combinationsCount = 0;

            for (int i = start; i <= end; i++)
            {
                for (int j = start; j <= end; j++)
                {
                    combinationsCount++;

                    if (i + j == magicNum)
                    {
                        Console.WriteLine($"Combination N:{combinationsCount} ({i} + {j} = {magicNum})");
                        return;
                    }
                }
            }

            Console.WriteLine($"{combinationsCount} combinations - neither equals {magicNum}");
        }
    }
}