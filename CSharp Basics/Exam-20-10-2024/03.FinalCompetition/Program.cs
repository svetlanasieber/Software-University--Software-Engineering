using System;

class Program
{
    static void Main()
    {
        
        int numOfDancers = int.Parse(Console.ReadLine());
        double points = double.Parse(Console.ReadLine());
        string season = Console.ReadLine();
        string location = Console.ReadLine();

        double moneyPrize = 0;

       
        if (location == "Bulgaria")
        {
            moneyPrize = points * numOfDancers;
            if (season == "summer")
            {
                moneyPrize -= 0.05 * moneyPrize;
            }
            else if (season == "winter")
            {
                moneyPrize -= 0.08 * moneyPrize;
            }
        }
        else if (location == "Abroad")
        {
            moneyPrize = points * numOfDancers + 0.5 * (points * numOfDancers);
            if (season == "summer")
            {
                moneyPrize -= 0.10 * moneyPrize;
            }
            else if (season == "winter")
            {
                moneyPrize -= 0.15 * moneyPrize;
            }
        }

       
        double charityMoney = 0.75 * moneyPrize;
        double moneyAfterCharity = moneyPrize - charityMoney;
        double moneyPerDancer = moneyAfterCharity / numOfDancers;

        
        Console.WriteLine($"Charity - {charityMoney:F2}");
        Console.WriteLine($"Money per dancer - {moneyPerDancer:F2}");
    }
}

