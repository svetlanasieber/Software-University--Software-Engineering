int sideA = int.Parse(Console.ReadLine());
int sideB = int.Parse(Console.ReadLine());
int sideC = int.Parse(Console.ReadLine());

if (sideA < sideB + sideC && sideB < sideA + sideC && sideC < sideA + sideB)
{
    Console.WriteLine("Valid Triangle");
}
else
{
    Console.WriteLine("Invalid Triangle");
}

