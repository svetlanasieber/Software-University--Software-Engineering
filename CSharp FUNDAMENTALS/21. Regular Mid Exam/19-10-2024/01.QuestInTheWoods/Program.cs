using System;
using System.Collections.Generic;
using System.Linq;

public class 01.QuestInTheWoods
{
    public static void Main(string[] args)
    {
        int days = int.Parse(Console.ReadLine());
        int participants = int.Parse(Console.ReadLine());
        double groupEnergy = double.Parse(Console.ReadLine());
        double waterPerPersonPerDay = double.Parse(Console.ReadLine());
        double foodPerPersonPerDay = double.Parse(Console.ReadLine());

        double totalWater = days * participants * waterPerPersonPerDay;
        double totalFood = days * participants * foodPerPersonPerDay;

        List<double> energyLosses = new List<double>();
        for (int i = 0; i < days; i++)
        {
            energyLosses.Add(double.Parse(Console.ReadLine()));
        }

        for (int day = 1; day <= days; day++)
        {
            groupEnergy -= energyLosses[day - 1];

            if (groupEnergy <= 0)
            {
                Console.WriteLine($"You will run out of energy. You will be left with {totalFood:F2} food and {totalWater:F2} water.");
                return;
            }

            if (day % 2 == 0)
            {
                groupEnergy += groupEnergy * 0.05;
                totalWater -= totalWater * 0.3;
            }

            if (day % 3 == 0)
            {
                groupEnergy += groupEnergy * 0.1;
                totalFood -= totalFood / participants;
            }
        }

        Console.WriteLine($"You are ready for the quest. You will be left with {groupEnergy:F2} energy!");
    }
}
