int n = int.Parse(Console.ReadLine()!);

bool isInRange = n >= 1 && n <= 100;

while (!isInRange)

{
    n = int.Parse(Console.ReadLine()!);
    isInRange = n >= 1 &&  n <= 100;
}
Console.WriteLine(n);
