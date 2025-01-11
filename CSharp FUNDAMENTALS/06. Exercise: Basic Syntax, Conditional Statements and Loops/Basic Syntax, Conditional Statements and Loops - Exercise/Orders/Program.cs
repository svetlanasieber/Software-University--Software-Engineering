int ordersCount = int.Parse(Console.ReadLine());
double total = 0;

for (int i = 1; i <= ordersCount; i++)
{

    double pricePerCapsule = double.Parse(Console.ReadLine());
    int days = int.Parse(Console.ReadLine());
    int capsuleCount = int.Parse(Console.ReadLine());

    double price = (days * capsuleCount) * pricePerCapsule;
    total += price;
    Console.WriteLine($"The price for the coffee is: ${price:F2}");
}

Console.WriteLine($"Total: ${total:F2}");

