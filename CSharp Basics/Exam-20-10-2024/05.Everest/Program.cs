using System;

class Program
{
    static void Main()
    {
        int daysCounter = 1;
        int metersCounter = 5364;
        bool isSucceeded = false;

        while (true)
        {
            string command = Console.ReadLine();
            if (command == "END")
            {
                break;
            }

            string isSpendingTheNight = command.ToLower();
            if (isSpendingTheNight == "yes")
            {
                daysCounter++;
            }

            int climbedMeters = int.Parse(Console.ReadLine());
            if (daysCounter > 5)
            {
                isSucceeded = false;
                break;
            }

            metersCounter += climbedMeters;

            if (metersCounter >= 8848)
            {
                isSucceeded = true;
                break;
            }
        }

        if (isSucceeded)
        {
            Console.WriteLine($"Goal reached for {daysCounter} days!");
        }
        else
        {
            Console.WriteLine("Failed!");
            Console.WriteLine(metersCounter);
        }
    }
}
