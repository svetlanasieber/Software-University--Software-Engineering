int number = int.Parse(Console.ReadLine());

PrintNumberType(number);

static void PrintNumberType(int number)
{
    if (number > 0)
    {
        Console.WriteLine($"The number {number} is positive.");
    }
    else if (number < 0)
    {
        Console.WriteLine($"The number {number} is negative.");
    }
    else
    {
        
        Console.WriteLine($"The number {number} is zero.");
    }
}

