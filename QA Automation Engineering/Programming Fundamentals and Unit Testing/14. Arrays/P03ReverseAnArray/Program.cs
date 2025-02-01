int n = int.Parse(Console.ReadLine()); 

int[] numbers = new int[n];

for (int index = 0; index <= numbers.Length - 1; index++)
{
    numbers[index] = int.Parse((Console.ReadLine()));
}

for (int index = numbers.Length - 1; index >= 0; index--)
{
    Console.Write(numbers[index] + " ");
}
