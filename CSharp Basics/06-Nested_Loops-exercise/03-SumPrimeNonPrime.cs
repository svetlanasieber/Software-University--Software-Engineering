using System;

namespace SumPrimeNonPrime
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            double sumPrime = 0;
            double sumNonPrime = 0;

            while (input != "stop")
            {
                int curNum = int.Parse(input);

                if (curNum < 0)
                {
                    Console.WriteLine("Number is negative.");
                    input = Console.ReadLine();
                    continue;
                }

                bool isPrime = true;

                for (int divisor = 2; divisor < curNum; divisor++)
                {
                    if (curNum % divisor == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                {
                    sumPrime += curNum;
                }
                else
                {
                    sumNonPrime += curNum;
                }

                input = Console.ReadLine();
            }

            Console.WriteLine($"Sum of all prime numbers is: {sumPrime}");
            Console.WriteLine($"Sum of all non prime numbers is: {sumNonPrime}");
        }
    }
}