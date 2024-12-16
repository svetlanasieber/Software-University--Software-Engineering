int n = int.Parse(Console.ReadLine());

for (int step = 0; step <= n; step += 2)
{
    Console.WriteLine(Math.Pow(2, step));
}
