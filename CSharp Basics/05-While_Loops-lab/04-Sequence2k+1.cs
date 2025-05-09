using System;

namespace Sequence2kPlus1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int k = 1;

            while (k <= n)
            {
                Console.WriteLine(k);
                k = k * 2 + 1;
            }
        }
    }
}