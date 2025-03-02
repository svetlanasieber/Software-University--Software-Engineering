int n = int.Parse(Console.ReadLine());

if (n <= 0)
{
    Console.WriteLine(0);
    return;
}

int cumulativeConsum = 0;

for (int i = 0; i < n; i++)
{
    int dailyConsumption = int.Parse(Console.ReadLine());
    cumulativeConsum += dailyConsumption;
    Console.WriteLine(cumulativeConsum);
}
