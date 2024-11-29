using System;

namespace SumNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int targetNum = int.Parse(Console.ReadLine());

            int sum = 0;

            while (sum < targetNum)
            {
                int curNum = int.Parse(Console.ReadLine());
                sum += curNum;
            }

            Console.WriteLine(sum);
        }
    }
}