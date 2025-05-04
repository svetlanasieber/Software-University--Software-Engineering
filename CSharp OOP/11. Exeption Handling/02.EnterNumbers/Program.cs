using System;
using System.Collections.Generic;

List<int> numbers = new();
int startRange = 1;
int endRange = 100;

while (numbers.Count < 10)
{
    try
    {
        int number = ReadNumber(startRange, endRange);

        numbers.Add(number);

        startRange = number;
    }
    catch (ArgumentException ex)
    {
        Console.WriteLine(ex.Message);
    }
}

Console.WriteLine($"{string.Join(", ", numbers)}");

int ReadNumber(int start, int end)
{
    string input = Console.ReadLine();

    if (!int.TryParse(input, out int number))
    {
        throw new ArgumentException("Invalid Number!");
    }
    else if (number <= start || number >= end)
    {
        throw new ArgumentException($"Your number is not in range {start} - {end}!");
    }

    return number;
}
