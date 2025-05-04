using System;

namespace CustomRandomList;

public class StartUp
{
    static void Main(string[] args)
    {
        RandomList randomList = new();

        randomList.Add("Ivan");
        randomList.Add("Misho");
        randomList.Add("Gosho");
        randomList.Add("Pesho");

        Console.WriteLine($"Removed item: ");
        Console.WriteLine(randomList.RandomString());
        Console.WriteLine();

        Console.WriteLine("Items left: ");
        foreach (string item in randomList)
        {
            Console.WriteLine(item);
        }
    }
}
