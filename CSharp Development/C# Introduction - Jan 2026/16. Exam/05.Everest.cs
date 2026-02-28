using System;

int days = 1;
int currentHeight = 5364;
const int EverestHeight = 8848;

string command = Console.ReadLine()!;

while (command != "END")
{
    if (command == "Yes")
    {
        days++;

        if (days > 5)
        {
            break;
        }
    }

    int climbedMeters = int.Parse(Console.ReadLine()!);
    currentHeight += climbedMeters;

    if (currentHeight >= EverestHeight)
    {
        break;
    }

    command = Console.ReadLine()!;
}

if (currentHeight >= EverestHeight)
{
    Console.WriteLine($"Goal reached for {days} days!");
}
else
{
    Console.WriteLine("Failed!");
    Console.WriteLine(currentHeight);
}
