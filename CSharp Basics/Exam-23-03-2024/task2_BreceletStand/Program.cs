using System;

class MainClass
{
    public static void Main(string[] args)
    {
       
        double dailyIncome = double.Parse(Console.ReadLine());
        double dailyEarnings = double.Parse(Console.ReadLine());
        double totalExpenses = double.Parse(Console.ReadLine());
        double giftPrice = double.Parse(Console.ReadLine());

        
        double savingsPocket = dailyIncome * 5;
        double earnings = dailyEarnings * 5;
        double totalSavings = savingsPocket + earnings - totalExpenses;

        
        if (totalSavings >= giftPrice)
        {
            Console.WriteLine($"Profit: {totalSavings:F2} BGN, the gift has been purchased.");
        }
        else
        {
            double neededMoney = giftPrice - totalSavings;
            Console.WriteLine($"Insufficient money: {neededMoney:F2} BGN.");
        }
    }
}
