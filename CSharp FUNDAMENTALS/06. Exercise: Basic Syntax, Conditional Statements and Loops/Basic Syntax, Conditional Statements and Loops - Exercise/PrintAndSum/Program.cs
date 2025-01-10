int start = int.Parse(Console.ReadLine());
int end = int.Parse(Console.ReadLine());

int sum = 0;

for (int i = start; i <= end; i++)
{
    Console.Write(i + " ");
    sum = sum + i; //sum += i;
}

Console.WriteLine();
Console.WriteLine($"Sum: {sum}");
