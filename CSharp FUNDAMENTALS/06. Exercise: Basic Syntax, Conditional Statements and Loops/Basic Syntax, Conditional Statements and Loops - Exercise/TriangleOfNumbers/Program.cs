int n = int.Parse(Console.ReadLine());

for (int row = 1; row <= n; row++)
{
    for (int count = 1; count <= row; count++)
    {
        Console.Write(row + " ");
    }

    Console.WriteLine();
}
