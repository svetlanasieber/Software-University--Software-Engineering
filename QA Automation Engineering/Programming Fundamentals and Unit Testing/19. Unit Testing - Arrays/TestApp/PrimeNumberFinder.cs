using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestApp;

public class PrimeNumberFinder
{
    public static int[] GetAllPrimeNumbers(int[] numbers)
    {
        StringBuilder sb = new StringBuilder();

        foreach (int number in numbers)
        {
            if (IsPrime(number))
            {
                sb.Append(number + " ");
            }
        }

        int[] resultSet = sb.ToString()
            .Split(' ', StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();

        return resultSet;
    }

    private static bool IsPrime(int number)
    {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        var boundary = (int)Math.Floor(Math.Sqrt(number));

        for (int i = 3; i <= boundary; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }
}
