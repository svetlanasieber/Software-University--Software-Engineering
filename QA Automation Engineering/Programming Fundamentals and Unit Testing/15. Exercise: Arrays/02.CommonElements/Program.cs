using System;
using System.Linq;

class Program
{
    static void Main()
    {
        
        int[] firstArray = Console.ReadLine()
                                  .Split(' ')
                                  .Select(int.Parse)
                                  .ToArray();

       
        int[] secondArray = Console.ReadLine()
                                   .Split(' ')
                                   .Select(int.Parse)
                                   .ToArray();

       
        int[] commonElements = firstArray.Intersect(secondArray).ToArray();
        Console.WriteLine(string.Join(" ", commonElements));
    }
}


/* ver2
int[] firstArray = Console.ReadLine()
						  .Split(" ")
						  .Select(int.Parse)
						  .ToArray();

int[] secondArray = Console.ReadLine()
						  .Split(" ")
						  .Select(int.Parse)
						  .ToArray();

for (int i = 0; i < firstArray.Length; i++)
{
	int currentElement = firstArray[i];

	for (int j = 0; j < secondArray.Length; j++)
	{
		if (currentElement == secondArray[j])
		{
			Console.Write(currentElement + " ");
		}
	}
}
*/

/*

/*ver3
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
*/
