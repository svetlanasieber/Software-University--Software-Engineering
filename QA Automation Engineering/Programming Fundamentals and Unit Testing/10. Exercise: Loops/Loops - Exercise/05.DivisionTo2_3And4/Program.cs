int num = int.Parse(Console.ReadLine());

int countDivisibleBy2 = 0;
int countDivisibleBy3 = 0;
int countDivisibleBy4 = 0;

for (int i = 0; i < num; i++)
{
    int currentNum = int.Parse(Console.ReadLine());

    if (currentNum % 2 == 0)
    {
        countDivisibleBy2++;
    }

    if (currentNum % 3 == 0)
    {
        countDivisibleBy3++;
    }
    
    if (currentNum % 4 == 0)
    {
        countDivisibleBy4++;
    }
}

double percentDivisibleBy2 = countDivisibleBy2 / (double)num * 100;
double percentDivisibleBy3 = countDivisibleBy3 / (double)num * 100;
double percentDivisibleBy4 = countDivisibleBy4 / (double)num * 100;

Console.WriteLine($"{percentDivisibleBy2:f2}%");
Console.WriteLine($"{percentDivisibleBy3:f2}%");
Console.WriteLine($"{percentDivisibleBy4:f2}%");

