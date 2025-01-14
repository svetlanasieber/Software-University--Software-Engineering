string movieType = Console.ReadLine();
int rows = int.Parse(Console.ReadLine());
int seats = int.Parse(Console.ReadLine());

double ticketPrice = 0;

switch (movieType)
{
    case "Premiere":
        ticketPrice = 12.00;
        break;
    case "Normal":
        ticketPrice = 7.50;
        break;
    case "Discount":
        ticketPrice = 5.00;
        break;
}

double profit = rows * seats * ticketPrice;

Console.WriteLine($"{profit:F2}");
