Queue<int> numbers = new(
    Console.ReadLine()
        .Split(' ', StringSplitOptions.RemoveEmptyEntries)
        .Select(int.Parse));

while (numbers.Count > 0)
{
    int number = numbers.Dequeue();

    if (number % 2 == 0)
    {
        Console.Write(number);

        if (numbers.Count > 0)
        {
            Console.Write(", ");
        }
    }
}
