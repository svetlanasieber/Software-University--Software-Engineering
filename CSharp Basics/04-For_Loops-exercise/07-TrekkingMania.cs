using System;

namespace TrekkingMania
{
    class Program
    {
        static void Main(string[] args)
        {
            int groupsCount = int.Parse(Console.ReadLine());

            int c1 = 0;
            int c2 = 0;
            int c3 = 0;
            int c4 = 0;
            int c5 = 0;

            for (int i = 1; i <= groupsCount; i++)
            {
                int people = int.Parse(Console.ReadLine());

                if (people <= 5)
                {
                    c1 += people;
                }
                else if (people <= 12)
                {
                    c2 += people;
                }
                else if (people <= 25)
                {
                    c3 += people;
                }
                else if (people <= 40)
                {
                    c4 += people;
                }
                else
                {
                    c5 += people;
                }
            }

            int total = c1 + c2 + c3 + c4 + c5;
            double p1 = ((double)c1 / total) * 100;
            double p2 = ((double)c2 / total) * 100;
            double p3 = ((double)c3 / total) * 100;
            double p4 = ((double)c4 / total) * 100;
            double p5 = ((double)c5 / total) * 100;

            Console.WriteLine($"{p1:f2}%");
            Console.WriteLine($"{p2:f2}%");
            Console.WriteLine($"{p3:f2}%");
            Console.WriteLine($"{p4:f2}%");
            Console.WriteLine($"{p5:f2}%");
        }
    }
}