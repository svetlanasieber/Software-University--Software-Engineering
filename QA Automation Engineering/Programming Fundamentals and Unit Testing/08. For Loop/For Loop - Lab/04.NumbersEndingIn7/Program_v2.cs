int startNumber = 7; 
int endNumber = int.Parse(Console.ReadLine());

for (int number = startNumber; number <= endNumber; number++)
{
    if (number % 10 == 7)
    {
        Console.WriteLine(number);
    }
}

