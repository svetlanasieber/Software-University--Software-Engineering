using System;
using System.Collections.Generic;

internal class Program
{
    static void Main()
    {
        int carsPassingOnGreen = int.Parse(Console.ReadLine());
        int totalCarsPassed = 0;
        var carsQueue = new Queue<string>();
        string input;
        while ((input = Console.ReadLine()) != "end")
        {
            if (input == "green")
                for (int i = 0; i < carsPassingOnGreen; i++)
                {
                    if (carsQueue.Count == 0) break;
                    Console.WriteLine($"{carsQueue.Dequeue()} passed!");
                    totalCarsPassed++;
                }
            else
                carsQueue.Enqueue(input);
        }
        Console.WriteLine($"{totalCarsPassed} cars passed the crossroads.");
    }
}
