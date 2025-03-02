namespace TestApp;

public static class EvenNumbersFinder
{
    public static string FindEvenNumbers(int start, int end)
    {
        if (start > end)
        {
            return "Start number should not be greater than end number.";
        }

        List<int> evenNumbers = new List<int>();

        for (int num = start; num <= end; num++)
        {
            if (num % 2 == 0)
            {
                evenNumbers.Add(num);
            }
        }

        return string.Join(" ", evenNumbers);
    }
}
