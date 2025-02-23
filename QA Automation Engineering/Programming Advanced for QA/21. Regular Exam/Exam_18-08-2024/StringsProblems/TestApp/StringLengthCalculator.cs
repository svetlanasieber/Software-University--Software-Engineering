namespace TestApp;

public class StringLengthCalculator
{
    public static int Calculate(string input)
    {
        int length = input.Length;
        int asciiSum = 0;

        foreach (char c in input)
        {
            asciiSum += c;
        }

        if (asciiSum == 0)
        {
            return 0;
        }

        if (length % 2 == 0)
        {
            return asciiSum * 2;
        }
        else
        {
            return (int)Math.Ceiling(asciiSum / 2.0);
        }
    }
}

