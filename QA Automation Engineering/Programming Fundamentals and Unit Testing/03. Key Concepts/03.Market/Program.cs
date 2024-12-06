double tomatoPrice = double.Parse(Console.ReadLine());
double tomatoQuantity  = double.Parse(Console.ReadLine());

double cucumberPrice = double.Parse(Console.ReadLine());
double cucumberQuiantity = double.Parse(Console.ReadLine());

double totalCost = tomatoPrice * tomatoQuantity +  cucumberPrice * cucumberQuiantity;
Console.WriteLine($"{totalCost:F2}");
