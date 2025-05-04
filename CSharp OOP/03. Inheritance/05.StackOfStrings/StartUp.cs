using System;
using System.Collections.Generic;

namespace CustomStack;

public class StartUp
{
    static void Main()
    {
        StackOfStrings stack = new();

        Console.WriteLine(stack.IsEmpty());

        stack.AddRange(new List<string> { "Ivan", "Pesho", "Gosho" });

        Console.WriteLine(stack.IsEmpty());
        Console.WriteLine();

        while (!stack.IsEmpty())
        {
            Console.WriteLine(stack.Pop());
        }
    }
}
