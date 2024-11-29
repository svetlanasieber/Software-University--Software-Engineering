using System;

namespace OperationsBetweenNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            string sign = Console.ReadLine();

            double result = 0.0;
            string evenStatus = "";

            switch (sign)
            {
                case "+":
                    result = n1 + n2;
                    evenStatus = result % 2 == 0 ? "even" : "odd";
                    Console.WriteLine($"{n1} + {n2} = {result} - {evenStatus}");
                    break;

                case "-":
                    result = n1 - n2;
                    evenStatus = result % 2 == 0 ? "even" : "odd";
                    Console.WriteLine($"{n1} - {n2} = {result} - {evenStatus}");
                    break;

                case "*":
                    result = n1 * n2;
                    evenStatus = result % 2 == 0 ? "even" : "odd";
                    Console.WriteLine($"{n1} * {n2} = {result} - {evenStatus}");
                    break;

                case "/":
                    if (n2 == 0)
                    {
                        Console.Write($"Cannot divide {n1} by zero");
                        break;
                    }

                    result = (double) n1 / n2;
                    Console.WriteLine($"{n1} / {n2} = {result:f2}");
                    break;

                case "%":
                    if (n2 == 0)
                    {
                        Console.Write($"Cannot divide {n1} by zero");
                        break;
                    }

                    result = n1 % n2;
                    Console.WriteLine($"{n1} % {n2} = {result}");
                    break;
            }
        }
    }
}