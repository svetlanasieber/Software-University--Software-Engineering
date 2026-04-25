using System;
using System.Collections.Generic;
using System.Linq;

namespace P02_GeneratingNumbers
{
    internal class P02_GeneratingNumbers
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            string command;
            while ((command = Console.ReadLine()) != "END")
            {
                string[] tokens = command.Split(' ', StringSplitOptions.RemoveEmptyEntries);

                if (command.StartsWith("add to start"))
                {
                    int[] toAdd = tokens.Skip(3).Select(int.Parse).ToArray();
                    numbers.InsertRange(0, toAdd);
                }
                else if (command.StartsWith("remove greater than"))
                {
                    int value = int.Parse(tokens[3]);
                    numbers.RemoveAll(n => n > value);
                }
                else if (command.StartsWith("replace"))
                {
                    int value = int.Parse(tokens[1]);
                    int replacement = int.Parse(tokens[2]);

                    int index = numbers.IndexOf(value);
                    if (index != -1)
                    {
                        numbers[index] = replacement;
                    }
                }
                else if (command.StartsWith("remove at index"))
                {
                    int index = int.Parse(tokens[3]);
                    if (index >= 0 && index < numbers.Count)
                    {
                        numbers.RemoveAt(index);
                    }
                }
                else if (command == "find even")
                {
                    Console.WriteLine(string.Join(" ", numbers.Where(n => n % 2 == 0)));
                }
                else if (command == "find odd")
                {
                    Console.WriteLine(string.Join(" ", numbers.Where(n => n % 2 != 0)));
                }
            }

            Console.WriteLine(string.Join(", ", numbers));
        }
    }
}
