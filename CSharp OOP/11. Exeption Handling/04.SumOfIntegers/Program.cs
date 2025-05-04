using System;

string[] tokens = Console.ReadLine().Split(' ');

int sum = 0;

foreach (var token in tokens)
{
    try
    {
        sum += int.Parse(token);
    }
    catch (FormatException)
    {
        Console.WriteLine($"The element '{token}' is in wrong format!");
    }
    catch (OverflowException)
    {
        Console.WriteLine($"The element '{token}' is out of range!");
    }
    finally
    {
        Console.WriteLine($"Element '{token}' processed - current sum: {sum}");
    }
}

Console.WriteLine($"The total sum of all integers is: {sum}");
