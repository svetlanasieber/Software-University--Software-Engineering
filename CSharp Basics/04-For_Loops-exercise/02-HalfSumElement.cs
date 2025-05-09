using System;

namespace HalfSumElement
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sum = 0;
            int max = 0;

            for (int i = 1; i <= n; i++)
            {
                int curNum = int.Parse(Console.ReadLine());

                if (curNum > max)
                {
                    max = curNum;
                }

                sum += curNum;
            }

            int othersSum = sum - max;

            if (max == othersSum)
            {
                Console.WriteLine($"Yes\nSum = {max}");
            }
            else
            {
                Console.WriteLine($"No\nDiff = {Math.Abs(othersSum - max)}");
            }
        }
    }
}