using System;

double partyPrice = double.Parse(Console.ReadLine()!);
int loveMessagesCount = int.Parse(Console.ReadLine()!);
int waxRosesCount = int.Parse(Console.ReadLine()!);
int keychainsCount = int.Parse(Console.ReadLine()!);
int caricaturesCount = int.Parse(Console.ReadLine()!);
int surpriseCount = int.Parse(Console.ReadLine()!);

double totalRevenue =
    loveMessagesCount * 0.60 +
    waxRosesCount * 7.20 +
    keychainsCount * 3.60 +
    caricaturesCount * 18.20 +
    surpriseCount * 22.00;

int totalItemsCount =
    loveMessagesCount +
    waxRosesCount +
    keychainsCount +
    caricaturesCount +
    surpriseCount;

if (totalItemsCount >= 25)
{
    totalRevenue *= 0.65; // 35% discount
}

double profit = totalRevenue * 0.90; // 10% hosting costs

if (profit >= partyPrice)
{
    double moneyLeft = profit - partyPrice;
    Console.WriteLine($"Yes! {moneyLeft:F2} lv left.");
}
else
{
    double neededMoney = partyPrice - profit;
    Console.WriteLine($"Not enough money! {neededMoney:F2} lv needed.");
}
