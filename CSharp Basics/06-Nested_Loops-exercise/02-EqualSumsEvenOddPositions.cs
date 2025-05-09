using System;

namespace EqualSumsEvenOddPositions
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());

            string result = "";

            for (int curNum = start; curNum <= end; curNum++)
            {
                string numAsStr = curNum.ToString();
                double oddSum = 0.0;
                double evenSum = 0.0;

                for (int i = 0; i < numAsStr.Length; i++)
                {
                    double digit = Char.GetNumericValue(numAsStr[i]);
                    int position = i + 1;

                    if (position % 2 == 0)
                    {
                        evenSum += digit;
                    }
                    else
                    {
                        oddSum += digit;
                    }
                }

                if (evenSum == oddSum)
                {
                    result += $"{numAsStr} ";
                }
            }

            Console.WriteLine(result);
        }
    }
}