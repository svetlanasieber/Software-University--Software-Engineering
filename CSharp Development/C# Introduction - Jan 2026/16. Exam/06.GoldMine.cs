using System;

int locationsCount = int.Parse(Console.ReadLine()!);

for (int location = 0; location < locationsCount; location++)
{
    double expectedAverageGold = double.Parse(Console.ReadLine()!);
    int days = int.Parse(Console.ReadLine()!);

    double totalGold = 0.0;

    for (int day = 0; day < days; day++)
    {
        double dailyGold = double.Parse(Console.ReadLine()!);
        totalGold += dailyGold;
    }

    double averageGold = totalGold / days;

    if (averageGold >= expectedAverageGold)
    {
        Console.WriteLine($"Good job! Average gold per day: {averageGold:F2}.");
    }
    else
    {
        double neededGold = expectedAverageGold - averageGold;
        Console.WriteLine($"You need {neededGold:F2} gold.");
    }
}
