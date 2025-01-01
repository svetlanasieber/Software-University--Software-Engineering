using System;
using System.Linq;


internal class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int total = 0;
        int[] wagons = new int[n];

        for (int i = 0; i < n; i++)
        {
            int passengers = int.Parse(Console.ReadLine());
            wagons[i] = passengers;
            total += wagons[i];
        }

        Console.WriteLine(string.Join(" ", wagons));
        Console.WriteLine(total);
      
    }
}
