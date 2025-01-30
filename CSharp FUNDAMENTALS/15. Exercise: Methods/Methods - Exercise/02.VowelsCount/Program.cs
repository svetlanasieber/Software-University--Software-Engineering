string product = Console.ReadLine();
int quantity = int.Parse(Console.ReadLine());

double finalPrice = GetFinalPrice(product, quantity);

Console.WriteLine($"{finalPrice:F2}");

static double GetFinalPrice(string product, int quantity)
{
    double priceOfProduct = 0;

    switch (product)
    {
        case "coffee": priceOfProduct = 1.50; break;
        case "water": priceOfProduct = 1.00; break;
        case "coke": priceOfProduct = 1.40; break;
        case "snacks": priceOfProduct = 2.00; break;
    }

    double finalPrice = priceOfProduct * quantity;

    return finalPrice;
}
