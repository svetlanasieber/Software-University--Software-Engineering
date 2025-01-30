int number = int.Parse(Console.ReadLine());
PrintTriangle(number);

static void PrintLine(int start, int end)
{
    for (int i = start; i <= end; i++)
    {
        Console.Write(i + " ");
    }
    Console.WriteLine();
}

static void PrintTriangle(int num)
{
    for (int line = 1; line <= num; line++)
    {
        PrintLine(1, line);
    }
    for (int line = num - 1; line >= 1; line--)
    {
        PrintLine(1, line);
    }
}

