using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        List<int> strengths = Console.ReadLine().Split().Select(int.Parse).ToList();
        Queue<int> accuracies = new Queue<int>(Console.ReadLine().Split().Select(int.Parse));

        int totalGoals = 0;

        while (strengths.Count > 0 && accuracies.Count > 0)
        {
            int strength = strengths[strengths.Count - 1];
            int accuracy = accuracies.Peek();

            int sum = strength + accuracy;

            if (sum == 100)
            {
                totalGoals++;
                strengths.RemoveAt(strengths.Count - 1);
                accuracies.Dequeue();
            }
            else if (sum < 100)
            {
                if (strength < accuracy)
                {
                    strengths.RemoveAt(strengths.Count - 1);
                }
                else if (strength > accuracy)
                {
                    accuracies.Dequeue();
                }
                else
                {
                    strengths[strengths.Count - 1] = strength + accuracy;
                    accuracies.Dequeue();
                }
            }
            else
            {
                strengths[strengths.Count - 1] -= 10;

                if (accuracies.Count > 1)
                {
                    int accuracyToMove = accuracies.Dequeue();
                    accuracies.Enqueue(accuracyToMove);
                }
            }
        }

       
        if (totalGoals == 3)
        {
            Console.WriteLine("Paul scored a hat-trick!");
        }
        else if (totalGoals == 0)
        {
            Console.WriteLine("Paul failed to score a single goal.");
        }
        else if (totalGoals > 3)
        {
            Console.WriteLine("Paul performed remarkably well!");
        }
        else
        {
            Console.WriteLine("Paul failed to make a hat-trick.");
        }

        if (totalGoals > 0)
        {
            Console.WriteLine($"Goals scored: {totalGoals}");
        }

        if (strengths.Count > 0)
        {
           
            strengths.Reverse();
            Console.WriteLine($"Strength values left: {string.Join(", ", strengths)}");
        }

        if (accuracies.Count > 0)
        {
            Console.WriteLine($"Accuracy values left: {string.Join(", ", accuracies)}");
        }
    }
}
