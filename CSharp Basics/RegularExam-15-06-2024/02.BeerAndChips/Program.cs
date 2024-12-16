string name = Console.ReadLine();
double budget = double.Parse(Console.ReadLine());
int numOfBeerBottles = int.Parse(Console.ReadLine());
int numOfBagChips = int.Parse(Console.ReadLine());

double beerPrice = 1.20;

double totalPriceForBeers = numOfBeerBottles * beerPrice;
double priceOfChips = totalPriceForBeers * 0.45;
double totalPriceForChips = Math.Ceiling(priceOfChips * numOfBagChips);

double sumOfChipsAndBeer = totalPriceForBeers + totalPriceForChips;

if (budget >= sumOfChipsAndBeer)
{
    double moneyLeft = budget - sumOfChipsAndBeer;
    Console.WriteLine($"{name} bought a snack and has {moneyLeft:F2} leva left.");
}
else if (budget < sumOfChipsAndBeer)
{
    double moneyNeeded = sumOfChipsAndBeer - budget;
    Console.WriteLine($"{name} needs {moneyNeeded:F2} more leva!");
}

