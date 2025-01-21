using System.Linq.Expressions;
using System.Runtime.ExceptionServices;

int[] array1 = Console.ReadLine()
                      .Split(' ')
                      .Select(int.Parse)
                      .ToArray();


int[] array2 = Console.ReadLine()
                      .Split(' ')
                      .Select(int.Parse)
                      .ToArray();

foreach (int element in array1)
{
    if (array2.Contains(element))
        Console.Write(element + " ");
}
