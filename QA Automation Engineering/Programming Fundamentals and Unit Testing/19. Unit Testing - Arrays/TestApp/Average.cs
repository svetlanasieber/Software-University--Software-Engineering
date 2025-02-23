using System;

namespace TestApp;

public class Average
{
    public static double CalculateAverage(int[] numbers)
    {
        int sum = 0;

        foreach (int number in numbers)
        {
            sum += number;
        }

        return (double)sum / numbers.Length;
    }
}

