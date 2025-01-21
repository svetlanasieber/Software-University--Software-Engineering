using System;
using System.Linq;

class Program
{
    static void Main()
    {
        
        int[] firstArray = Console.ReadLine()
                                  .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                                  .Select(int.Parse)
                                  .ToArray();

       
        int[] secondArray = Console.ReadLine()
                                   .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                                   .Select(int.Parse)
                                   .ToArray();

       
        int[] commonElements = firstArray.Intersect(secondArray).ToArray();
        Console.WriteLine(string.Join(" ", commonElements));
    }
}
