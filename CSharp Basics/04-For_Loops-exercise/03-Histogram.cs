using System;

namespace Histogram
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int c1 = 0;
            int c2 = 0;
            int c3 = 0;
            int c4 = 0;
            int c5 = 0;

            for (int i = 1; i <= n; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num < 200)
                {
                    c1++;
                }
                else if (num < 400)
                {
                    c2++;
                }
                else if (num < 600)
                {
                    c3++;
                }
                else if (num < 800)
                {
                    c4++;
                }
                else
                {
                    c5++;
                }
            }

            double p1 = ((double) c1 / n) * 100;
            double p2 = ((double) c2 / n) * 100;
            double p3 = ((double) c3 / n) * 100;
            double p4 = ((double) c4 / n) * 100;
            double p5 = ((double) c5 / n) * 100;

            Console.WriteLine($"{p1:f2}%");
            Console.WriteLine($"{p2:f2}%");
            Console.WriteLine($"{p3:f2}%");
            Console.WriteLine($"{p4:f2}%");
            Console.WriteLine($"{p5:f2}%");
        }
    }
}