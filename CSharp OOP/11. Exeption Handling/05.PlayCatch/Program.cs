using System;
using System.Linq;

int[] numbers = Console.ReadLine()
    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

int count = 0;
while (count < 3)
{
    try
    {
        string[] input = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
        string command = input[0];
        if (command == "Replace")
        {
            int index = int.Parse(input[1]);
            int element = int.Parse(input[2]);

            numbers[index] = element;

        }
        else if (command == "Print")
        {
            int startIndex = int.Parse(input[1]);
            int endIndex = int.Parse(input[2]);

            if (endIndex > numbers.Length - 1)
            {
                throw new IndexOutOfRangeException();
            }

            for (int i = startIndex; i < endIndex; i++)
            {
                Console.Write(numbers[i] + ", ");
            }

            Console.Write(numbers[endIndex]);
            Console.WriteLine();
        }
        else if (command == "Show")
        {
            int index = int.Parse(input[1]);
            Console.WriteLine(numbers[index]);
        }
    }
    catch (IndexOutOfRangeException)
    {
        Console.WriteLine("The index does not exist!");
        count++;

    }
    catch (FormatException)
    {
        Console.WriteLine("The variable is not in the correct format!");
        count++;
    }

}

Console.WriteLine(string.Join(", ", numbers));